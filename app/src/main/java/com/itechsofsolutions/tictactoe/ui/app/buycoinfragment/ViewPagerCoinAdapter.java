package com.itechsofsolutions.tictactoe.ui.app.buycoinfragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerCoinAdapter extends FragmentPagerAdapter {
      private int numOfTabs;


    public ViewPagerCoinAdapter(FragmentManager fm, int behaviour){
        super(fm, behaviour);
        this.numOfTabs = behaviour;


    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
