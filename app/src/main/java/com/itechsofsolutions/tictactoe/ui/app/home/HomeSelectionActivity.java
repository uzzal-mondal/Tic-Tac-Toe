package com.itechsofsolutions.tictactoe.ui.app.home;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.ActivityHomeBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;
import com.itechsoftsolution.ebay.utils.helper.SharedPrefUtils;

import org.jetbrains.annotations.NotNull;

public class HomeSelectionActivity extends BaseActivity<HomeSelectionMvpView,
        HomeSelectionPresenter> {

    private ActivityHomeBinding mBinding;


    int player = 1;
    int gameState[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[][] winPosition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    Boolean active = true;


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


    }

    @Override
    protected void stopUI() {


    }

    public void selectionPlayer() {

        String playerOnes = SharedPrefUtils.INSTANCE.readString("playerOne", "");
        String playerTwos = SharedPrefUtils.INSTANCE.readString("playerTwo", "");
        mBinding.p1TV.setText(playerOnes + " " + "(X): 0");
        mBinding.p2TV.setText(playerTwos + " " + "(0): 0");

        mBinding.buttonReset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //resetBoard();
            }
        });

    }


    public void tapped(View view) {

        ImageView img = (ImageView) view;
        String tagValue = img.getTag().toString();
        Log.i("tag", tagValue);

        if (active && gameState[Integer.parseInt(tagValue)] == 0) {
            gameState[Integer.parseInt(tagValue)] = player;
            Log.i("pressed", tagValue + "Selected by player" + player);

            img.setTranslationY(-1500);

            if (player == 1) {
                img.setImageResource(R.drawable.circle);
                img.animate().translationYBy(1500).rotation(360 * 10).setDuration(5);
                player = 2;
            } else if (player == 2) {
                img.setImageResource(R.drawable.cross);
                img.animate().translationYBy(1500).rotation(360 * 10).setDuration(5);
                player = 1;
            }


            //winning position.
            for (int[] wininigPosition : winPosition) {

                if (gameState[wininigPosition[0]] == gameState[wininigPosition[1]] &&
                        gameState[wininigPosition[1]] == gameState[wininigPosition[2]] &&
                        gameState[wininigPosition[0]] != 0) {

                    active = false;
                    String win = "";
                    if (player == 1) {
                        win = "player 1";
                    } else if (player == 2) {
                        win = "Player 2";
                    } else {
                        win = "Match Draw";
                    }

                    if (player == 1 || player == 2) {
                        mBinding.scoreText.setText(win + " , Won the game.");
                    } else if (player != 0) {
                        mBinding.scoreText.setText(win + " , Match draw");
                    }


                    mBinding.buttonReset.setVisibility(View.VISIBLE);
                    mBinding.scoreText.setVisibility(View.VISIBLE);

                }
            }

            boolean check = true;

            for (int i = 0; i < gameState.length; i++) {
                if (gameState[i] == 0) {
                    check = false;
                }
            }

            if (check) {
                mBinding.buttonReset.setVisibility(View.VISIBLE);
            }


        }

    }

    public void playButton(View view) {

        //  playButton.setVisibility(View.VISIBLE);
        //  tWinner.setVisibility(View.VISIBLE);


        mBinding.imageView1.setImageDrawable(null);
        mBinding.imageView2.setImageDrawable(null);
        mBinding.imageView3.setImageDrawable(null);
        mBinding.imageView4.setImageDrawable(null);
        mBinding.imageView5.setImageDrawable(null);
        mBinding.imageView6.setImageDrawable(null);
        mBinding.imageView7.setImageDrawable(null);
        mBinding.imageView8.setImageDrawable(null);
        mBinding.imageView9.setImageDrawable(null);


        player = 1;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 0;
        }

    }


}

