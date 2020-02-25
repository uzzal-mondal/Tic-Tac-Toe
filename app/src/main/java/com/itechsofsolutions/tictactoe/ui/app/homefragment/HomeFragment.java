package com.itechsofsolutions.tictactoe.ui.app.homefragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.FragmentHomeBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends BaseFragment<HomeMvpView, HomePresenter>
        implements HomeMvpView {


    private FragmentHomeBinding mBinding;
    private EventAdapter eventAdapter;
    private ProfileAdapter profileAdapter;
    private CatogoriesAdapter catogoriesAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @NotNull
    @Override
    protected HomePresenter getFragmentPresenter() {
        return new HomePresenter();
    }


    @Override
    protected void startUI() {
        mBinding = (FragmentHomeBinding) getViewDataBinding();

        inItListener();
        inItAdapter();
    }

    private void inItListener() {
        setClickListener(mBinding.textViewEvents, mBinding.textViewSeeAll,
                mBinding.textViewChallenge,mBinding.textViewSeeAllSecond,
                mBinding.textViewFollowed,mBinding.textViewSeeAllThird);
    }

    @Override
    protected void stopUI() {

    }

    @Override
    public void onClick(@NotNull View view) {
        super.onClick(view);

        switch (view.getId()) {


        }

    }


    private void inItAdapter() {

        //  if (!list.isEmpty()){
        mBinding.recyclerHome.setVisibility(View.VISIBLE);
        eventAdapter = new EventAdapter(getActivity());
        mBinding.recyclerHome.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        mBinding.recyclerHome.setAdapter(eventAdapter);

        profileAdapter = new ProfileAdapter(getActivity());
        mBinding.recyclerProfile.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL,false));
        mBinding.recyclerProfile.setAdapter(profileAdapter);


        catogoriesAdapter = new CatogoriesAdapter(getActivity());
        mBinding.recyclerCategories.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL,false));
        mBinding.recyclerCategories.setAdapter(catogoriesAdapter);


    }


    @Override
    public void onBackPressed() {


    }
}
