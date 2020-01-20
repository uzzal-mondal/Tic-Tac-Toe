package com.itechsofsolutions.tictactoe.ui.app.home;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends BaseActivity<HomeSelectionMvpView, HomeSelectionPresenter> {

    // player 1 = 0, player 2 = X;
    int player = 1;
    int gameState[] ={0,0,0,0,0,0,0,0,0};
    int winPosition[][] = {{0,1,2},{3,4,5},{6,7,8}, {0,3,6}, {1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};

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


    }

    @Override
    protected void stopUI() {

    }

    public void tapped(View view) {

        ImageView img = (ImageView) view;
        String value = img.getTag().toString();
        Log.i("value",value);


        gameState[Integer.parseInt(value)] = player;
        img.setTranslationY(-1500);

        if (player==1){
            img.setImageResource(R.drawable.circle);
            img.animate().translationYBy(1500).rotation(360*10).setDuration(1000);
            player = 2;
        }else if (player == 2){
           img.setImageResource(R.drawable.cross);
           img.animate().translationXBy(1500).rotation(360*10).setDuration(1000);
           player = 1;
        }



        for (int[] winnerPos : winPosition){
            if (gameState[winnerPos[0]] == gameState[winnerPos[1]] &&
                    gameState[winnerPos[1]] == gameState[winnerPos[2]] &&
                    gameState[winnerPos[0]] != 0){

                String winner = "";
                if (player == 1){
                    winner = "player 1";
                } else{
                    winner ="player 2";
                }

                Toast.makeText(this, winner+" won the game", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
