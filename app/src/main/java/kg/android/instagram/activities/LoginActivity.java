package kg.android.instagram.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import instagramlogin.InstApp;
import instagramlogin.InstagramSession;
import instagramlogin.OAuthAuthenticationListener;
import kg.android.instagram.ApplicationData;
import kg.android.instagram.R;
import kg.android.instagram.network.RestClient;

public class LoginActivity extends Activity {
    private static final String TAG = "LoginActivity";
    private InstApp mApp;
    private InstagramSession instagramSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mApp = new InstApp(this, ApplicationData.CLIENT_ID,
                ApplicationData.CLIENT_SECRET, ApplicationData.CALLBACK_URL);
        instagramSession = new InstagramSession(this);

        if (instagramSession.getAccessToken() != null) {
            RestClient.setAccessToken(instagramSession.getAccessToken());
            Log.d(TAG, "Access token is : " + instagramSession.getAccessToken());
            login();
        } else {
            authorize();
        }

    }

    OAuthAuthenticationListener listener = new OAuthAuthenticationListener() {
        @Override
        public void onSuccess() {
            Log.d("Login Item", "Success");
            RestClient.setAccessToken(mApp.getAccessToken());
            instagramSession.storeAccessToken(mApp.getAccessToken());
            login();
        }

        @Override
        public void onFail(String error) {
            Log.d("Login Item", "Failed");
        }
    };

    private void login() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.loginButton)
    public void onLoginButtonClick(View view) {
        if (mApp != null) {
            authorize();
        }
    }

    private void authorize() {
        mApp.setListener(listener);
        mApp.authorize();
    }

}
