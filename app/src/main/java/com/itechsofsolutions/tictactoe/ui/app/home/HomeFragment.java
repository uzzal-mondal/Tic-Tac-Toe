package com.itechsofsolutions.tictactoe.ui.app.home;

import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends BaseActivity<HomeMvpView, HomePresenter> {





    @Override
    protected int getLayoutResourceId() {
        return 0;
    }

    @NotNull
    @Override
    protected HomePresenter getActivityPresenter() {
        return null;
    }

    @Override
    protected void startUI() {

    }

    @Override
    protected void stopUI() {

    }
}
