package com.jefeko.apptwoway.utils;

import android.app.Activity;
import android.widget.Toast;

import com.jefeko.apptwoway.R;

/**
 * Created by Nexmore on 2018-01-22.
 */

public class BackPressCloseUtil {

    private long mBackKeyPressedTime = 0;
    private Activity mActivity;
    private Toast mToast;

    public BackPressCloseUtil(Activity activity) { mActivity = activity; }

    public void onBackPressed() {
        if (System.currentTimeMillis() > mBackKeyPressedTime + 2000) {
            mBackKeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }
        if (System.currentTimeMillis() <= mBackKeyPressedTime + 2000) {
            mToast.cancel();
            mActivity.finish();
        }
    }

    public void showGuide() {
        mToast = Toast.makeText(mActivity, R.string.back_btn_message, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
