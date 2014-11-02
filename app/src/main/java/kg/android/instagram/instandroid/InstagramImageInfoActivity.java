package kg.android.instagram.instandroid;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class InstagramImageInfoActivity extends Activity {
    private ImageView avatarImageView;
    private TextView usernameTextView;
    private ImageView instagramImageView;
    private TextView captionTextView;
    private InstagramPhoto photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_image_info);

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

    }

}
