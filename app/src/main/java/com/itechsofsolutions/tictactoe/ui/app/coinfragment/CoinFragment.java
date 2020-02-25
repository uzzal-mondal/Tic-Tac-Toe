package com.itechsofsolutions.tictactoe.ui.app.coinfragment;
import android.content.Context;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.FragmentCoinBinding;
import com.itechsofsolutions.tictactoe.ui.base.callback.MvpView;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class CoinFragment extends BaseFragment<CoinMvpView,CoinPresenter>
        implements MvpView {

    FragmentCoinBinding mBinding;
    ViewPagerAdapter pagerAdapter;

    Context context;

    CoinFragment(Context context){
        this.context = context;
    }



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
        inItViewPager();
        initTabLayout();

        mBinding.tabLayout.setupWithViewPager(mBinding.viewPagerBottom);
        //setClickListener(mBinding.tabCoin,mBinding.tabCoinHistory);

    }

    @Override
    protected void stopUI() {

    }

   /* @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_buycoin,container,false);
    }*/

    public void inItViewPager(){

        pagerAdapter = new ViewPagerAdapter(getFragmentManager(),2);
        /*pagerAdapter.addFragment(new BuyCoinFragment(),"Buy Coin");
        pagerAdapter.addFragment(new BuyHistoryFragment(),"Buy History");*/
        mBinding.viewPagerBottom.setAdapter(pagerAdapter);
       /* mBinding.viewPagerBottom.addOnPageChangeListener(new TabLayout.
                TabLayoutOnPageChangeListener(mBinding.tabLayout));*/

       mBinding.viewPagerBottom.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {


           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

    }

    public void initTabLayout(){
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
