package com.itechsofsolutions.tictactoe.ui.app.authnetication.signup;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.ActivitySignupBinding;
import com.itechsofsolutions.tictactoe.ui.app.authnetication.signin.SignInActivity;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;
import org.jetbrains.annotations.NotNull;
public class SignUpActivity extends BaseActivity<SignUpMvpView,SignUpPresenter>implements SignUpMvpView{

   ActivitySignupBinding mBinding;
   public static SignUpActivity signUpActivity;



    public static void runActivity(Activity mActivity) {
        mActivity.startActivity(new Intent(mActivity, SignUpActivity.class));
    }


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_signup;
    }

    @NotNull
    @Override
    protected SignUpPresenter getActivityPresenter() {
        return new SignUpPresenter();
    }

    @Override
    protected void startUI() {

        mBinding = (ActivitySignupBinding)getViewDataBinding();
        signUpActivity = this;
        initClickListener();


    }

   private void initClickListener(){

        setClickListener(mBinding.textViewSignIns);

   }

    @Override
    protected void stopUI() {

    }

    @Override
    public void onClick(@NotNull View view) {
        super.onClick(view);
        if (view.getId() == R.id.text_view_sign_ins){
            SignInActivity.runActivity(this);
        }
    }
}
