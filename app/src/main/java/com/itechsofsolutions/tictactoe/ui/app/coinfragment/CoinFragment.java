package com.itechsofsolutions.tictactoe.ui.app.coinfragment;

import com.google.android.material.tabs.TabLayout;
import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.FragmentCoinBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class CoinFragment extends BaseFragment<CoinMvpView, CoinPresenter> {

    FragmentCoinBinding mBinding;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_coin;
    }

    @NotNull
    @Override
    protected CoinPresenter getFragmentPresenter() {
        return new CoinPresenter();
    }

    @Override
    protected void startUI() {

        mBinding = (FragmentCoinBinding) getViewDataBinding();
        mBinding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        initTabLayout();
        inItViewPager();

    }

    @Override
    protected void stopUI() {

    }

    public void inItViewPager() {

        viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(),
                mBinding.tabLayout.getTabCount());
        mBinding.viewPagerBottom.setAdapter(viewPagerAdapter);
        mBinding.viewPagerBottom.addOnPageChangeListener(new TabLayout.
                TabLayoutOnPageChangeListener(mBinding.tabLayout));

    }

    public void initTabLayout() {
        mBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                mBinding.viewPagerBottom.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



    @Override
    public void onBackPressed() {

    }
}
