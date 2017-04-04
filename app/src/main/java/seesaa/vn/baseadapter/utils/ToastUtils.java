package seesaa.vn.baseadapter.utils;

import android.content.Context;
import android.widget.Toast;

import seesaa.vn.baseadapter.Application;


public class ToastUtils {

    private static Toast sToast;

    public static void showToast(Context context, String message) {
        if (sToast != null) sToast.cancel();
        sToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        sToast.show();
    }
}
