package com.itechsofsolutions.tictactoe.ui.app.categoriesfragment;

import android.content.Context;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.data.local.model.home_model.EventModel;
import com.itechsofsolutions.tictactoe.databinding.ItemCategoriesBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseAdapter;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

public class GeneralAdapter extends BaseAdapter<EventModel> {

    private Context context;

    public GeneralAdapter(Context context){
        this.context = context;
    }


    @Override
    public boolean isEqual(EventModel left, EventModel right) {
        return false;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @NotNull
    @Override
    public BaseViewHolder<EventModel> newViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new GeneralViewHolder(inflate(parent, R.layout.item_categories));
    }



    public class GeneralViewHolder extends BaseViewHolder<EventModel>{
        ItemCategoriesBinding mBinding;


        public GeneralViewHolder(@NotNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            this.mBinding = (ItemCategoriesBinding) viewDataBinding;

        }

        @Override
        public void bind(EventModel item) {

            if (item!=null){
                mBinding.imageViewItemCategories.setOnClickListener(this::onClick);
            }

        }
    }
}
