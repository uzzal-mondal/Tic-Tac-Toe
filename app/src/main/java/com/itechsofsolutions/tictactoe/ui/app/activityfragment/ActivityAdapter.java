package com.itechsofsolutions.tictactoe.ui.app.activityfragment;

import android.content.Context;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.data.local.model.activity_model.ActivityModel;
import com.itechsofsolutions.tictactoe.databinding.ItemActivityBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseAdapter;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

public class ActivityAdapter extends BaseAdapter<ActivityModel> {


    private Context context;

    public ActivityAdapter(Context context){
        this.context = context;
    }

    @Override
    public boolean isEqual(ActivityModel left, ActivityModel right) {
        return false;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @NotNull
    @Override
    public BaseViewHolder<ActivityModel> newViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new ActivityViewHolder(inflate(parent, R.layout.item_activity));
    }

    public class ActivityViewHolder extends BaseViewHolder<ActivityModel>{
        private ItemActivityBinding mBinding;

        public ActivityViewHolder(@NotNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            this.mBinding = (ItemActivityBinding) viewDataBinding;
        }

        @Override
        public void bind(ActivityModel item) {

            if (item!=null){
                mBinding.profileImage.setOnClickListener(this::onClick);
                mBinding.textViewMg.setOnClickListener(this:: onClick);
                mBinding.textViewNum.setOnClickListener(this::onClick);
            }

        }
    }
}
