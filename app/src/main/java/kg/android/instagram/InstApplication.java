package kg.android.instagram;

import android.app.Application;
import android.content.res.Configuration;

import com.facebook.drawee.backends.pipeline.Fresco;

import timber.log.Timber;

public class InstApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        Fresco.initialize(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
