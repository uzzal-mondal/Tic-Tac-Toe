package com.itechsofsolutions.tictactoe.ui.app.homefragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.data.local.model.home_model.EventModel;
import com.itechsofsolutions.tictactoe.databinding.ItemCategoriesBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseAdapter;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

public class CatogoriesAdapter extends BaseAdapter<EventModel> {


    private Context context;
    private AdapterItemClickListener mListener;

    public CatogoriesAdapter(Context context){
        this.context = context;
    }



    @Override
    public boolean isEqual(EventModel left, EventModel right) {
        return false;
    }

    public void setmListener(AdapterItemClickListener mListener){
        this.mListener = mListener;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @NotNull
    @Override
    public BaseViewHolder<EventModel> newViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new CategoriesViewHolder(inflate(parent, R.layout.item_categories));
    }

    public class CategoriesViewHolder extends BaseViewHolder<EventModel>{
        ItemCategoriesBinding mBinding;

        public CategoriesViewHolder(@NotNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            this.mBinding = (ItemCategoriesBinding) viewDataBinding;
        }

        @Override
        public void bind(EventModel item) {
            if (item!=null){
                //GlideUtils.Companion.glideWithPlaceHolder(mBinding.imageViewItemEvents, DataUtils.Companion.g());
                mBinding.imageViewItemCategories.setOnClickListener(this::onClick);
            }
        }

        @Override
        public void onClick(@NotNull View view) {
            super.onClick(view);
        }
    }
}
