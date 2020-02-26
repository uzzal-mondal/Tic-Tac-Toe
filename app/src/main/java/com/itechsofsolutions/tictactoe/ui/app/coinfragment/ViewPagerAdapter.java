package com.itechsofsolutions.tictactoe.ui.app.coinfragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.itechsofsolutions.tictactoe.ui.app.buycoinfragment.BuyCoinFragment;
import com.itechsofsolutions.tictactoe.ui.app.buyhistoryfragment.BuyHistoryFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new BuyHistoryFragment();

                default:
                    return new BuyCoinFragment();
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }

}
