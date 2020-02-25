package com.itechsofsolutions.tictactoe.ui.app.sciencefragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.FragmentScienceBinding;
import com.itechsofsolutions.tictactoe.ui.app.homefragment.HomeMvpView;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class ScienceFragment extends BaseFragment<ScienceMvpView, SciencePresenter>
        implements HomeMvpView {

    private FragmentScienceBinding mBinding;
    private ListAdapter listAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_science;
    }

    @NotNull
    @Override
    protected SciencePresenter getFragmentPresenter() {
        return new SciencePresenter();
    }

    @Override
    protected void startUI() {
        mBinding = (FragmentScienceBinding) getViewDataBinding();
        inItListener();
        inItAdapter();

    }

    @Override
    protected void stopUI() {

    }

    private void inItListener() {
        setClickListener();
    }

    private void inItAdapter() {

        listAdapter = new ListAdapter(getActivity());
        mBinding.recyclerScience.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        mBinding.recyclerScience.setAdapter(listAdapter);
    }

    @Override
    public void onBackPressed() {

    }
}
