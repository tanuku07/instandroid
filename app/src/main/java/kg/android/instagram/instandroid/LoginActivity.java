package kg.android.instagram.instandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import InstagramLogin.InstagramApp;
import InstagramLogin.OAuthAuthenticationListener;
import kg.android.instagram.instandroid.adapters.InstagramPhotosAdapter;
import kg.android.instagram.instandroid.model.Comment;
import kg.android.instagram.instandroid.model.InstagramPhoto;


public class LoginActivity extends Activity {
    private InstagramPhotosAdapter photosAdapter;
    private InstagramApp mApp;
    private ListView listView;
    private ArrayList<InstagramPhoto> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        listView = (ListView) findViewById(R.id.listView);

        mApp = new InstagramApp(this, ApplicationData.CLIENT_ID,
                ApplicationData.CLIENT_SECRET, ApplicationData.CALLBACK_URL);
        mApp.setListener(listener);
        mApp.authorize();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent instagramInfo = new Intent(LoginActivity.this, InstagramImageInfoActivity.class);
                instagramInfo.putExtra("PHOTO", photos.get(position));
                startActivity(instagramInfo);
            }
        });

    }

    private void fetchFeed() throws JSONException{
            photos = new ArrayList<InstagramPhoto>();
            photosAdapter = new InstagramPhotosAdapter(this, photos);
            listView.setAdapter(photosAdapter);
            String userFeedURL = "/users/self/feed?access_token=" + mApp.getAccessToken();
            InstagramRestClient.get(userFeedURL, null, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    JSONArray photosJSON = null;
                    try {
                        photosAdapter.clear();
                        photosJSON = response.getJSONArray("data");
                        for (int i = 0; i < photosJSON.length(); i++) {
                            JSONObject photoJSON = photosJSON.getJSONObject(i);
                            InstagramPhoto photo = new InstagramPhoto();
                            photo.username = photoJSON.getJSONObject("user").getString("username");
                            if (!photoJSON.isNull("caption")){
                                photo.caption = photoJSON.getJSONObject("caption").getString("text");
                            }
                            photo.avatarURL = photoJSON.getJSONObject("user").getString("profile_picture");
                            photo.imageURL = photoJSON.getJSONObject("images").getJSONObject("standard_resolution").getString("url");
                            photo.likesCount = photoJSON.getJSONObject("likes").getInt("count");


                            photo.comment_list = new ArrayList<Comment>();
                            JSONArray comments = photoJSON.getJSONObject("comments").getJSONArray("data");
                            for (int j = 0; j < comments.length(); j++) {
                                JSONObject commentObj = comments.getJSONObject(j);
                                Comment comment = new Comment(commentObj.getJSONObject("from").getString("username"), commentObj.getString("text"), commentObj.getJSONObject("from").getString("profile_picture"));
                                photo.comment_list.add(comment);
                            }
                            photos.add(photo);
                        }
                        photosAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                }
            });
    }

    OAuthAuthenticationListener listener = new OAuthAuthenticationListener() {
        @Override
        public void onSuccess() {
            Log.d("Login Item","Success");
            try {
                fetchFeed();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFail(String error) {
            Log.d("Login Item", "Failed");
        }
    };

}
