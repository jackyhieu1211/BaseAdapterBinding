package seesaa.vn.baseadapter.utils;

import android.content.Context;
import android.widget.Toast;

import seesaa.vn.baseadapter.Application;


public class ToastUtils {

    private static Toast sToast;

    public static void showToast(String message) {
        if (sToast != null) sToast.cancel();
        sToast = Toast.makeText(Application.getContext(), message, Toast.LENGTH_SHORT);
        sToast.show();
    }
}
