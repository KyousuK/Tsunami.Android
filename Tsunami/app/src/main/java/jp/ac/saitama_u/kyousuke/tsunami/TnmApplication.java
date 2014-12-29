package jp.ac.saitama_u.kyousuke.tsunami;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by usr0200379 on 2014/12/30.
 */
public class TnmApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }
}
