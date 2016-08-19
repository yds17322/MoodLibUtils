package ds.dk.yuoto.libutils.Utils;

import android.content.Context;
import android.widget.Toast;

import ds.dk.yuoto.libutils.BuildConfig;

/**
 * Created by deshui.yu on 16-8-19.
 * 只允许Toast弹一次
 */
public class ToastUtils {
    private static Toast mToast = null;


    public static void show(Context context, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

}
