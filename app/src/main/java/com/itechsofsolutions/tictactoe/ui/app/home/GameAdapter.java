package com.itechsofsolutions.tictactoe.ui.app.home;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.data.local.model.GameModel;
import com.itechsofsolutions.tictactoe.databinding.ItemGameLayoutBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseAdapter;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseViewHolder;
import com.itechsofsolutions.tictactoe.utils.libs.ToastUtils;

import org.jetbrains.annotations.NotNull;


public class GameAdapter extends BaseAdapter<GameModel> {

    private Context context;
    private GameItemClickListener mListener;
    private boolean isPlayerXedTurn;


    public void setListener(GameItemClickListener mListener) {
        this.mListener = mListener;
    }

    public GameAdapter(Context context) {
        this.context = context;
    }

    @Override
    public boolean isEqual(GameModel left, GameModel right) {
        return false;
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    @NotNull
    @Override
    public BaseViewHolder<GameModel> newViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new GameViewHolder(inflate(parent, R.layout.item_game_layout));

    }
    class GameViewHolder extends BaseViewHolder<GameModel> {
        private ItemGameLayoutBinding mBinding;


        public GameViewHolder(@NotNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            mBinding = (ItemGameLayoutBinding) viewDataBinding;

        }

        @Override
        public void bind(GameModel item) {
            mBinding.itemTextView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(@NotNull View view) {
            super.onClick(view);

            if(view.getId() == R.id.item_text_view){
                GameModel model = getItem(getAdapterPosition());
                if(model != null){
                    if(model.isPressed){
                        ToastUtils.INSTANCE.error("its already pressed");
                    }else {
                        if(!isPlayerXedTurn) {
                            model.setItemText("X");
                            mBinding.itemTextView.setText(model.getItemText());
                            model.isPressed = true;
                            isPlayerXedTurn = !isPlayerXedTurn;
                            mListener.itemGameListener(model, getAdapterPosition());

                        }else {
                            model.setItemText("O");
                            mBinding.itemTextView.setText(model.getItemText());
                            model.isPressed = true;
                            isPlayerXedTurn = !isPlayerXedTurn;
                            mListener.itemGameListener(model, getAdapterPosition());
                        }
                    }

                }

            }

        }
    }

}


