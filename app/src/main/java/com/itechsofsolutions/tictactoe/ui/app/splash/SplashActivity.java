package com.itechsofsolutions.tictactoe.ui.app.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.ui.app.team.TeamSelectionActivity;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class SplashActivity  extends
        BaseActivity<SplashSelectionMvpView,SplashSelectionPresenter> {


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
       // return setTheme(R.style.AppTheme);
    }

    @NotNull
    @Override
    protected SplashSelectionPresenter getActivityPresenter() {
        return new SplashSelectionPresenter();
    }

    @Override
    protected void startUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow()
                    .getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        setStatusBarColor(this,R.color.app_background);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,
                        TeamSelectionActivity.class));
                finish();
            }
        },2000);

    }

    public void setStatusBarColor(Activity activity, int colorRes){
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(activity,colorRes));
    }

    @Override
    protected void stopUI() {

    }
}
