package com.itechsofsolutions.tictactoe.ui.app.container;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.ActivityContainerBinding;
import com.itechsofsolutions.tictactoe.ui.app.activityfragment.ActivityFragment;
import com.itechsofsolutions.tictactoe.ui.app.categoriesfragment.CategoriesFragment;
import com.itechsofsolutions.tictactoe.ui.app.coinfragment.CoinFragment;
import com.itechsofsolutions.tictactoe.ui.app.homefragment.HomeFragment;
import com.itechsofsolutions.tictactoe.ui.app.sciencefragment.ScienceFragment;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class ContainerActivity extends BaseActivity<ContainerMvpView, ContainerPresenter> {


    private ActivityContainerBinding mBinding;
    private AppCompatTextView toolbarTitle;
    private AppCompatImageView searchView;
    private boolean isHomeFragment = true;


    private static ContainerActivity containerActivity;

    public static void runActivity(Activity mActivity) {
        mActivity.startActivity(new Intent(mActivity, ContainerActivity.class));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_container;
    }

    @NotNull
    @Override
    protected ContainerPresenter getActivityPresenter() {
        return new ContainerPresenter();
    }


    @Override
    protected void startUI() {

        mBinding = (ActivityContainerBinding) getViewDataBinding();
        containerActivity = this;

        initListener();
        isHomeFragment = true;
        commitFragment(R.id.constraint_layout_full_fragment_container, new HomeFragment());

    }

    @Override
    protected void stopUI() {

        if (containerActivity != null) {
            containerActivity.finish();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private void initListener() {
        setClickListener(mBinding.imageViewLogo, mBinding.imageViewNewsFeed,
                mBinding.imageViewCategories, mBinding.imageViewBuyCoin,
                mBinding.imageViewActivity);


    }


    @Override
    public void onClick(@NotNull View view) {
        super.onClick(view);

        switch (view.getId()) {

            case R.id.image_view_logo:
                isHomeFragment = false;
                commitFragment(R.id.constraint_layout_full_fragment_container, new HomeFragment());
                break;


            case R.id.image_view_news_feed:
                commitFragment(R.id.constraint_layout_full_fragment_container, new ScienceFragment());
                break;


            case R.id.image_view_buy_coin:
                commitFragment(R.id.constraint_layout_full_fragment_container, new CoinFragment());
                break;


            case R.id.image_view_categories:
                commitFragment(R.id.constraint_layout_full_fragment_container, new CategoriesFragment());
                break;


            case R.id.image_view_activity:
                commitFragment(R.id.constraint_layout_full_fragment_container, new ActivityFragment());
                break;


        }


    }
}
