package kettsuninc.android_dev_templete;

import android.app.Application;

/**
 * My App.
 * Created by yuji on 16/09/10.
 */
public class App extends Application {
    private static final String TAG = App.class.getCanonicalName();
    private static App instance;

    public App() {
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    public static String getResString(int resId) {
        return instance.getString(resId);
    }
}
