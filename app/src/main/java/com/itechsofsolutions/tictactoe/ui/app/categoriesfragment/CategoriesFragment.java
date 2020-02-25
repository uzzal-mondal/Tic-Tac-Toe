package com.itechsofsolutions.tictactoe.ui.app.categoriesfragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.FragmentCategoriesBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class CategoriesFragment extends BaseFragment<CategoriesMvpView, CategoriesPresenter>
        implements CategoriesMvpView {

    private FragmentCategoriesBinding mBinding;
    private GeneralAdapter generalAdapter;




    @Override
    protected int getLayoutId() {
        return R.layout.fragment_categories;
    }

    @NotNull
    @Override
    protected CategoriesPresenter getFragmentPresenter() {
        return new CategoriesPresenter();
    }

    @Override
    protected void startUI() {
        mBinding = (FragmentCategoriesBinding) getViewDataBinding();

        inItAdapter();

    }

    private void inItListener(){

    }

    @Override
    protected void stopUI() {

    }

    @Override
    public void onClick(@NotNull View view) {
        super.onClick(view);
    }

    private void inItAdapter(){

        generalAdapter  = new GeneralAdapter(getActivity());
        mBinding.recyclerGeneral.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        mBinding.recyclerGeneral.setAdapter(generalAdapter);


        generalAdapter = new GeneralAdapter(getActivity());
        mBinding.recyclerEntertainment.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        mBinding.recyclerEntertainment.setAdapter(generalAdapter);


        generalAdapter = new GeneralAdapter(getActivity());
        mBinding.recyclerFood.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        mBinding.recyclerFood.setAdapter(generalAdapter);


        generalAdapter = new GeneralAdapter(getActivity());
        mBinding.recyclerScience.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        mBinding.recyclerScience.setAdapter(generalAdapter);


    }

    @Override
    public void onBackPressed() {

    }
}
