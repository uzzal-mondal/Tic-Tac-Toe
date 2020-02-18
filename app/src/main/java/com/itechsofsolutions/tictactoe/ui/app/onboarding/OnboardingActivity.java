package com.itechsofsolutions.tictactoe.ui.app.onboarding;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.ActivityOnboardingBinding;
import com.itechsofsolutions.tictactoe.ui.app.authnetication.signin.SignInActivity;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class OnboardingActivity extends BaseActivity<OnboardingMvpView, OnboardingPresenter>
        implements OnboardingMvpView {

    private ActivityOnboardingBinding mBinding;
    public static OnboardingActivity onboardingActivity;


    public static void runActivity(Activity mActivity) {
        mActivity.startActivity(new Intent(mActivity, OnboardingActivity.class));

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_onboarding;
    }

    @NotNull
    @Override
    protected OnboardingPresenter getActivityPresenter() {
        return new OnboardingPresenter();
    }

    @Override
    protected void startUI() {

        mBinding = (ActivityOnboardingBinding) getViewDataBinding();
        onboardingActivity = this;
        initClickListener();
        inItViewPager();



    }

    public void inItViewPager(){

        OnBoardingAdapter adapter = new OnBoardingAdapter(this);
        mBinding.viewPager.setAdapter(adapter);
        mBinding.indicator.setViewPager(mBinding.viewPager);

        mBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    mBinding.buttonNext.setText(R.string.next);
                } else if (position == 1) {
                    mBinding.buttonNext.setText(R.string.next);
                } else if (position == 2) {
                    mBinding.buttonNext.setText(R.string.get_started);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /**
     * initializing all views click listener
     */
    private void initClickListener() {
        setClickListener(mBinding.buttonNext);
    }

    @Override
    protected void stopUI() {
        if (onboardingActivity != null){
            onboardingActivity = null;
        }
    }

    @Override
    public void onClick(@NotNull View view) {
        super.onClick(view);

        if (view.getId() == R.id.button_next){
            SignInActivity.runActivity(this);
        }

    }
}
