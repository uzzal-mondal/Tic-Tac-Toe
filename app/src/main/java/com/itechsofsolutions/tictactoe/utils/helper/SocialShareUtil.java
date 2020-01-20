package com.itechsofsolutions.tictactoe.utils.helper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.utils.libs.ToastUtils;

public class SocialShareUtil {

    public static SocialShareUtil on() {
        return new SocialShareUtil();
    }

    public void shareOnSocialMedia(Activity activity, String url, int type) {
        String packageName = "";
        switch (type) {
            case 1:
                packageName = "com.facebook.katana";
                break;
            case 2:
                packageName = "com.linkedin.android";
                break;
            case 3:
                packageName = "com.google.android.gm";
                break;
            case 4:
                packageName = "com.twitter.android";

                break;
            case 5:
                packageName = "com.instagram.android";
                break;
        }


        Intent intent = activity.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setPackage(packageName);

            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "http://www.google.com");
            // Start the specific social application
            activity.startActivity(shareIntent);
        } else {
            if(type == 1) {
                String sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=" + "http://www.google.com";
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
                activity.startActivity(intent);
            }else {
                ToastUtils.INSTANCE.error(activity.getString(R.string.install_the_app));
            }
        }
    }
}
