package com.itechsofsolutions.tictactoe.ui.app.home;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.ActivityHomeBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;
import com.itechsoftsolution.ebay.utils.helper.SharedPrefUtils;

import org.jetbrains.annotations.NotNull;

public class HomeSelectionActivity extends BaseActivity<HomeSelectionMvpView,
        HomeSelectionPresenter> {

    private ActivityHomeBinding mBinding;
    private ImageView[][] img = new ImageView[3][3];


    private int player1Points = 0, player2Points = 0;
    private int roundCount = 0;
    private Boolean player1Tern = true;
    private String Player1Name, Player2Name;


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
        setClickListener();



       String playerOnes = SharedPrefUtils.INSTANCE.readString("playerOne","");
       String playerTwos = SharedPrefUtils.INSTANCE.readString("playerTwo","");
       mBinding.p1TV.setText(playerOnes+" "+"(X): 0");
       mBinding.p2TV.setText(playerTwos+" "+"(0): 0");


        mBinding.buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    @Override
    protected void stopUI() {

    }










}

