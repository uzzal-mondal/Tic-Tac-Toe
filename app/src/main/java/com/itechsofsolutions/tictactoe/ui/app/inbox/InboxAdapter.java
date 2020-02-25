package com.itechsofsolutions.tictactoe.ui.app.inbox;

import android.content.Context;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.data.local.model.home_model.ProfileModel;
import com.itechsofsolutions.tictactoe.databinding.ItemInboxBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseAdapter;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

public class InboxAdapter extends BaseAdapter<ProfileModel> {

    private Context context;



    public InboxAdapter(Context context){
        this.context = context;
    }


    @Override
    public boolean isEqual(ProfileModel left, ProfileModel right) {
        return false;
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @NotNull
    @Override
    public BaseViewHolder<ProfileModel> newViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new InboxViewHolder(inflate(parent,R.layout.item_inbox)) ;
    }

    public class InboxViewHolder extends BaseViewHolder<ProfileModel>{
        ItemInboxBinding  mBinding;

        public InboxViewHolder(@NotNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            mBinding = (ItemInboxBinding) viewDataBinding;
        }

        @Override
        public void bind(ProfileModel item) {

            if (item!=null){
                mBinding.imageViewFriend.setOnClickListener(this::onClick);
            }
        }
    }
}
