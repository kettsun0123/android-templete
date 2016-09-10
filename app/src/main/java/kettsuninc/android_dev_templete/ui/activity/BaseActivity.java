package kettsuninc.android_dev_templete.ui.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import kettsuninc.android_dev_templete.App;
import kettsuninc.android_dev_templete.util.Constant;

/**
 * Base of all activities.
 * Created by yuji on 16/09/11.
 */
public abstract class BaseActivity extends AppCompatActivity {
    static final String TAG = BaseActivity.class.getSimpleName();
    private final BaseActivity self = this;

    public App getMyApplication() {
        return (App) getApplication();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void errorMessage(View view,String error) {
        Snackbar.make(view, error, Snackbar.LENGTH_SHORT).setAction(Constant.TEXT_CLOSE, v -> {
            v.setVisibility(View.GONE);
        });
    }

}