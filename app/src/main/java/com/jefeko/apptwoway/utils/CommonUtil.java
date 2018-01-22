package com.jefeko.apptwoway.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Nexmore on 2018-01-22.
 */

public class CommonUtil {
    public static int getConnectivityStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        int STATUS = 2;

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                STATUS = 0;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                STATUS = 1;
            }
        } else {
            STATUS = 2;
        }
        return STATUS;
    }

    public static void popupNetwork(final Context context) {
        new AlertDialog.Builder(context)
                .setTitle("네트워크 오류")
                .setMessage("네트워크 상태를 확인해주세요. 앱이 종료됩니다.")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (context instanceof Activity){
                            ((Activity) context).finish();
                        }
                    }
                }).show();
    }
}
