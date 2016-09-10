package kettsuninc.android_dev_templete.ui.fragment;

import android.support.v4.app.Fragment;

import kettsuninc.android_dev_templete.ui.activity.BaseActivity;

/**
 * Base of all fragments.
 * Created by yuji on 16/09/11.
 */
public abstract class BaseFragment extends Fragment {
    public static final String TAG = BaseFragment.class.getSimpleName();
    private final BaseFragment self = this;

    boolean mFirstTime = true;
    boolean mAutoTracking = true;

    public void setAutoTracking(boolean autoTracking) {
        mAutoTracking = autoTracking;
    }

    public String getTrackingParams() {
        return "";
    }

    public boolean requireAuth() {
        return true;
    }

    public boolean onBackPressed() {
        // Overwrite this!!
        return false;
    }

    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }
}
