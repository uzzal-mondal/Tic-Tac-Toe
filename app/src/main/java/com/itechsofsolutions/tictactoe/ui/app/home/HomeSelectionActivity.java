package com.itechsofsolutions.tictactoe.ui.app.home;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.data.local.model.GameModel;
import com.itechsofsolutions.tictactoe.databinding.ActivityHomeBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;
import com.itechsoftsolution.ebay.utils.helper.SharedPrefUtils;

import org.jetbrains.annotations.NotNull;
public class HomeSelectionActivity extends BaseActivity<HomeSelectionMvpView,
        HomeSelectionPresenter> implements GameItemClickListener {

    private ActivityHomeBinding mBinding;
    private GameAdapter mAdapter;
    int[][] gPlay = new int[3][3];
    int row = 0;
    int col = 0;


    // ..
    public static void runActivity(Activity mActivity) {
        mActivity.startActivity(new Intent(mActivity, HomeSelectionActivity.class));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home;
    }

    @NotNull
    @Override
    protected HomeSelectionPresenter getActivityPresenter() {
        return new HomeSelectionPresenter();
    }

    @Override
    protected void startUI() {

        mBinding = (ActivityHomeBinding) getViewDataBinding();
        selectionPlayer();
        setClickListener();

        mAdapter = new GameAdapter(this);
        mBinding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mBinding.recyclerView.setAdapter(mAdapter);
        mAdapter.setListener(this);

        for (col = 0; col < 3; col++) {
            for (row = 0; row < 3; row++) {
                gPlay[col][row] = -1;
            }
        }
    }

    @Override
    protected void stopUI() {


    }

    public void selectionPlayer() {
        String playerOnes = SharedPrefUtils.INSTANCE.readString("playerOne", "");
        String playerTwos = SharedPrefUtils.INSTANCE.readString("playerTwo", "");
        mBinding.p1TV.setText(playerOnes + " " + "(X): 0");
        mBinding.p2TV.setText(playerTwos + " " + "(0): 0");
    }

    @Override
    public void itemGameListener(GameModel item, int position) {

        if (position==1){
            gPlay[1][2] = 1;
        }else if (position == 2){
            gPlay[col][row] = 2;
        }else if(position == 3){
            gPlay[col][row] = 3;
        }else if (position == 4){
            gPlay[col][row] = 4;
        }else if(position == 5){
            gPlay[col][row]= 5;
        }else if(position == 6){
            gPlay[col][row] = 6;
        }else if (position == 7){
            gPlay[col][row] = 7;
        }else if(position==8){
            gPlay[col][row] = 8;
        }else if(position==9){
            gPlay[col][row] = 9;
        }
    }
    @Override
    public void onClick(@NotNull View view) {
        super.onClick(view);


    }
}

