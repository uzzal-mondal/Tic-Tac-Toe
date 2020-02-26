package com.itechsofsolutions.tictactoe.ui.app.buycoinfragment;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.FragmentBuyCoinBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class BuyCoinFragment extends BaseFragment<BuyCoinMvpView, BuyCoinPresenter>{


    FragmentBuyCoinBinding mBinding;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_buy_coin;
    }

    @NotNull
    @Override
    protected BuyCoinPresenter getFragmentPresenter() {
        return new BuyCoinPresenter();
    }

    @Override
    protected void startUI() {
        mBinding = (FragmentBuyCoinBinding) getViewDataBinding();
    }

    @Override
    protected void stopUI() {

    }


    @Override
    public void onBackPressed() {

    }
}
