package com.itechsofsolutions.tictactoe.ui.app.activityfragment;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.FragmentActivityBinding;
import com.itechsofsolutions.tictactoe.ui.app.homefragment.HomeMvpView;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class ActivityFragment extends BaseFragment<ActivityMvpView, ActivityPresenter>
implements HomeMvpView {


    private FragmentActivityBinding mBinding;
    private ActivityAdapter activityAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_activity;
    }

    @NotNull
    @Override
    protected ActivityPresenter getFragmentPresenter() {
        return new ActivityPresenter();
    }

    @Override
    protected void startUI() {
        mBinding = (FragmentActivityBinding) getViewDataBinding();
        inItAdapter();

    }

    @Override
    protected void stopUI() {


    }

    private void inItAdapter(){
        activityAdapter = new ActivityAdapter(getActivity());
        /*mBinding.recyclerActivity.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,false));
        mBinding.recyclerActivity.setAdapter(activityAdapter);*/
    }


    @Override
    public void onBackPressed() {


    }

}
