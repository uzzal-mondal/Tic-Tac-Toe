package com.itechsofsolutions.tictactoe.ui.app.homefragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.data.local.model.home_model.ProfileModel;
import com.itechsofsolutions.tictactoe.databinding.ItemProfileBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseAdapter;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

public class ProfileAdapter extends BaseAdapter<ProfileModel> {

    private Context context;
    private AdapterItemClickListener mlistener;

    public ProfileAdapter(Context context){
        this.context = context;
    }

    @Override
    public boolean isEqual(ProfileModel left, ProfileModel right) {
        return false;
    }

    public void setmListener(AdapterItemClickListener mlistener){
        this.mlistener = mlistener;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @NotNull
    @Override
    public BaseViewHolder<ProfileModel> newViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new ProfileViewHolder(inflate(parent, R.layout.item_profile));
    }

    public class ProfileViewHolder extends BaseViewHolder<ProfileModel>{
        ItemProfileBinding mBinding;


        public ProfileViewHolder(@NotNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            this.mBinding = (ItemProfileBinding) viewDataBinding;
        }

        @Override
        public void bind(ProfileModel item) {

            if (item!=null){
                mBinding.imageViewItemProfile.setOnClickListener(this::onClick);
            }

        }

        @Override
        public void onClick(@NotNull View view) {
            super.onClick(view);
        }
    }


}
