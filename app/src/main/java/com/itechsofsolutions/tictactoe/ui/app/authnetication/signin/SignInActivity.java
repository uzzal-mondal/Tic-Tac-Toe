package com.itechsofsolutions.tictactoe.ui.app.authnetication.signin;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.ActivitySigninBinding;
import com.itechsofsolutions.tictactoe.ui.app.authnetication.signup.SignUpActivity;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class SignInActivity extends BaseActivity<SignInMvpView, SignInPresenter> {

    ActivitySigninBinding mBinding;
    public static SignInActivity signInActivity;

    public static void runActivity(Activity mActivity) {
        mActivity.startActivity(new Intent(mActivity, SignInActivity.class));
    }


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_signin;
    }

    @NotNull
    @Override
    protected SignInPresenter getActivityPresenter() {
        return new SignInPresenter();
    }

    @Override
    protected void startUI() {
        mBinding = (ActivitySigninBinding) getViewDataBinding();
        signInActivity = this;
        inItClickListener();

    }


    @Override
    protected void stopUI() {

    }

    public void inItClickListener() {
        setClickListener(mBinding.textViewSignUps);
    }

    @Override
    public void onClick(@NotNull View view) {
        super.onClick(view);
        if (view.getId() == R.id.text_view_signUps) {
            SignUpActivity.runActivity(this);
        }
    }
}
