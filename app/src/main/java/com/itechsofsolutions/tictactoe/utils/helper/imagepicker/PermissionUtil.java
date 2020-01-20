package com.itechsofsolutions.tictactoe.utils.helper.imagepicker;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtil {
    public static final int REQUEST_CODE_PERMISSION_DEFAULT = 1;
    public static final int REQUEST_CODE_PERMISSION_PICK_IMAGE = 2;
    public static final int REQUEST_CODE_PERMISSION_CAMERA = 3;

    private static Context mContext;
    private static PermissionUtil invokePermission;

    private PermissionUtil() {

    }

    public static synchronized PermissionUtil on(Context context) {
        if (invokePermission == null) {
            invokePermission = new PermissionUtil();
        }

        mContext = context;

        return invokePermission;
    }

    public boolean request(String... str) {

        if (mContext == null) return false;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        List<String> finalArgs = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            if (mContext.checkSelfPermission(str[i]) != PackageManager.PERMISSION_GRANTED) {
                finalArgs.add(str[i]);
            }
        }

        if (finalArgs.isEmpty()) {
            return true;
        }

        ((Activity) mContext).requestPermissions(finalArgs.toArray(new String[finalArgs.size()]), REQUEST_CODE_PERMISSION_DEFAULT);

        return false;
    }

    public boolean request(int requestCode, String... str) {
        return request(null, requestCode, str);
    }

    public boolean request(Fragment fragment, int requestCode, String... str) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        List<String> finalArgs = new ArrayList<>();
        for (String aStr : str) {
            if (mContext.checkSelfPermission(aStr) != PackageManager.PERMISSION_GRANTED) {
                finalArgs.add(aStr);
            }
        }

        if (finalArgs.isEmpty()) {
            return true;
        }

        if(fragment == null) {

            ((Activity) mContext).requestPermissions(finalArgs.toArray(new String[finalArgs.size()]), requestCode);

        } else {

            fragment.requestPermissions(finalArgs.toArray(new String[finalArgs.size()]), requestCode);

        }

        return false;
    }

  /*  public boolean isAllowed(String... str) {
        if (mContext == null || !CollectionUtil.hasItem(str)) return false;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        for( String permissionFor : str) {
            if(!isAllowed(permissionFor)) {
                return false;
            }
        }

        return true;
    }*/

    public boolean isAllowed(String str) {
        if (mContext == null) return false;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        return mContext.checkSelfPermission(str) == PackageManager.PERMISSION_GRANTED;

    }
}