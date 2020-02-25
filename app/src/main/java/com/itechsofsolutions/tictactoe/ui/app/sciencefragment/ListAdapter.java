package com.itechsofsolutions.tictactoe.ui.app.sciencefragment;

import android.content.Context;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.data.local.model.science_model.ScienceModel;
import com.itechsofsolutions.tictactoe.databinding.ItemRowOneBinding;
import com.itechsofsolutions.tictactoe.databinding.ItemRowSecondBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseAdapter;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

public class ListAdapter extends BaseAdapter<ScienceModel> {


    int position=20;
    private Context context;

    public ListAdapter(Context context){
        this.context = context;
    }


    @Override
    public boolean isEqual(ScienceModel left, ScienceModel right) {
        return false;
    }

    @Override
    public int getItemCount() {

        if (position%2==0){
            return position;
        }else {
            return position;
        }


    }

    @NotNull
    @Override
    public BaseViewHolder<ScienceModel> newViewHolder(@NotNull ViewGroup parent, int viewType) {
      //  return new ScienceVieHolder(inflate(parent, R.layout.item_row_one));
      //  return new ScienceVieHolder(inflate(parent, R.layout.item_row_second));

       // View view;
        if (viewType==0){
            return new ScienceVieHolder(inflate(parent, R.layout.item_row_one));
        }else {
            return new ScienceVieHolder(inflate(parent, R.layout.item_row_second));
        }


         //return new ScienceVieHolder(inflate(parent, R.layout.item_row_one));
    }

    public class ScienceVieHolder extends BaseViewHolder<ScienceModel>{
        ItemRowOneBinding mBinding;
        ItemRowSecondBinding mSecondBinding;

        public ScienceVieHolder(@NotNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            this.mBinding = (ItemRowOneBinding) viewDataBinding;
           // this.mSecondBinding = (ItemRowSecondBinding) viewDataBinding;
        }

        @Override
        public void bind(ScienceModel item) {
            if (item!=null){
                mBinding.imageViewList.setOnClickListener(this::onClick);
                mBinding.textViewList.setOnClickListener(this::onClick);


                mSecondBinding.imageViewSecondList.setOnClickListener(this::onClick);
                mSecondBinding.textViewSecondList.setOnClickListener(this::onClick);



            }

        }
    }
}
