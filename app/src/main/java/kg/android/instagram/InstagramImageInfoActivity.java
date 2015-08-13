package kg.android.instagram;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import kg.android.instagram.instandroid.R;
import kg.android.instagram.adapters.InstagramCommentsAdapter;
import kg.android.instagram.model.InstagramPhoto;


public class InstagramImageInfoActivity extends Activity {
    private ListView listView;
    private ImageView avatarImageView;
    private TextView usernameTextView;
    private ImageView instagramImageView;
    private TextView captionTextView;
    private InstagramPhoto photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_image_info);

        listView = (ListView) findViewById(R.id.commentsListView);
        avatarImageView = (ImageView) findViewById(R.id.userImageView);
        usernameTextView = (TextView) findViewById(R.id.loginTextView);
        instagramImageView = (ImageView) findViewById(R.id.photoView);
        captionTextView = (TextView) findViewById(R.id.captionTextView);

        photo = (InstagramPhoto) getIntent().getExtras().get("PHOTO");

        avatarImageView.setImageResource(0);

        Picasso.with(this).load(photo.avatarURL).into(avatarImageView);

        usernameTextView.setText(photo.username);

        instagramImageView.setImageResource(0);

        Picasso.with(getApplicationContext()).load(photo.imageURL).into(instagramImageView);

        String s = "<b>" + photo.username + "</b> " + photo.caption;

        captionTextView.setText(Html.fromHtml(s));

        InstagramCommentsAdapter commentsApadter = new InstagramCommentsAdapter(this, photo.comment_list);

        listView.setAdapter(commentsApadter);

    }

}
