package com.itechsofsolutions.tictactoe.ui.app.splash;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.ui.app.onboarding.OnboardingActivity;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;
import com.itechsofsolutions.tictactoe.utils.helper.Constants;
import com.itechsoftsolution.ebay.utils.helper.SharedPrefUtils;
import org.jetbrains.annotations.NotNull;

public class SplashActivity extends BaseActivity<SplashMvpView,SplashPresenter> {


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @NotNull
    @Override
    protected SplashPresenter getActivityPresenter() {
        return new SplashPresenter();
    }

    @Override
    protected void startUI() {

        ((NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE)).cancelAll();
        new Handler().postDelayed(() -> {
            String lang = SharedPrefUtils.INSTANCE.readString(Constants.PreferenceKeys.LANGUAGE_CODE, "");
            if (lang.isEmpty()) {
                SharedPrefUtils.INSTANCE.write(Constants.PreferenceKeys.LANGUAGE_CODE, "en");
            }
            if (SharedPrefUtils.INSTANCE.readBoolean(Constants.PreferenceKeys.IS_LOGGED_IN)) {
                OnboardingActivity.runActivity(SplashActivity.this);
                finish();
            } else {
                OnboardingActivity.runActivity(SplashActivity.this);
                finish();
            }
        }, Constants.Default.DELAY_SPLASH);

    }

    @Override
    protected void stopUI() {

    }
}
