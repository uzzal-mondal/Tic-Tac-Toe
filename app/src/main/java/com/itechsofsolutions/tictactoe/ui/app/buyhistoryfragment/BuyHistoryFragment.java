package com.itechsofsolutions.tictactoe.ui.app.buyhistoryfragment;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.FragmentBuyHistoryBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class BuyHistoryFragment extends BaseFragment<BuyHistoryMvpView, BuyHistoryPresenter> {

   FragmentBuyHistoryBinding mBinding;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_buy_history;
    }

    @NotNull
    @Override
    protected BuyHistoryPresenter getFragmentPresenter() {
        return new BuyHistoryPresenter();
    }

    @Override
    protected void startUI() {

        mBinding = (FragmentBuyHistoryBinding) getViewDataBinding();

    }

    @Override
    protected void stopUI() {

    }

    @Override
    public void onBackPressed() {

    }
}
