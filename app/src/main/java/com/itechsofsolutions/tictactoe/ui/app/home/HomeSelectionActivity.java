package com.itechsofsolutions.tictactoe.ui.app.home;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.ActivityHomeBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;
import com.itechsoftsolution.ebay.utils.helper.SharedPrefUtils;

import org.jetbrains.annotations.NotNull;

public class HomeSelectionActivity extends BaseActivity<HomeSelectionMvpView,
        HomeSelectionPresenter> {

    private ActivityHomeBinding mBinding;


  /*  //1==0, 2==X
    int player = 1;
   // private AppCompatImageView[][] imageViews = new AppCompatImageView[3][3];
    int img [][] = new  int[3][3];
    private Boolean playerTern = true;
    private int roundCount = 0;*/

    //1==0, 2==X
    int player = 1;
    int gameState[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[][] winPosition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    Boolean active = true;
    Button playButton;


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
       // inItView();


        String playerOnes = SharedPrefUtils.INSTANCE.readString("playerOne", "");
        String playerTwos = SharedPrefUtils.INSTANCE.readString("playerTwo", "");
        mBinding.p1TV.setText(playerOnes + " " + "(X): 0");
        mBinding.p2TV.setText(playerTwos + " " + "(0): 0");

        mBinding.buttonReset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // resetBoard();

            }
        });

    }

    @Override
    protected void stopUI() {


    }

   /* public void inItView(){
        for (int col= 0; col<3; col++){
            for (int row = 0; row<3; row++){
                img [col][row] = -1;
            }
        }

    }*/

   /*public void inItView(){

       playButton = findViewById(R.id.button_reset);

   }*/


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
                img.animate().translationYBy(1500).rotation(360 * 10).setDuration(1000);
                player = 2;
            } else if(player == 2) {
                img.setImageResource(R.drawable.cross);
                img.animate().translationYBy(1500).rotation(360 * 10).setDuration(1000);
                player = 1;
            }


            //winning position.
            for (int[] wininigPosition : winPosition) {

                if (gameState[wininigPosition[0]] == gameState[wininigPosition[1]] &&
                        gameState[wininigPosition[1]] == gameState[wininigPosition[2]] &&
                        gameState[wininigPosition[0]] != 0) {

                    active = false;
                    String win = "";
                    if (player == 1)
                        win = "player 1";
                    else
                        win = "Player 2";




                    mBinding.scoreText.setText(win + " , Won the game.");
                    /*Toast.makeText(this, win + "won the grame..",
                            Toast.LENGTH_SHORT).show();*/






           /* AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            // set title
            alertDialogBuilder.setTitle("This is title");
            // alertDialogBuilder.setIcon(R.drawable.ic_delete);

            // set dialog message
            alertDialogBuilder
                    .setMessage("This is the message")
                    .setCancelable(false)
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, close
                            // current activity


                            //winning position.
                            for (int[] wininigPosition : winPosition) {

                                if (gameState[wininigPosition[0]] == gameState[wininigPosition[1]] &&
                                        gameState[wininigPosition[1]] == gameState[wininigPosition[2]] &&
                                        gameState[wininigPosition[0]] != 0) {

                                    active = false;
                                    String win = "";
                                    if (player == 1)
                                        win = "player 1";
                                    else
                                        win = "Player 2";

                                    tWinner.setText(win + "Won the game.");

                                    MainActivity.this.finish();


                                    playButton.setVisibility(View.VISIBLE);
                                    tWinner.setVisibility(View.VISIBLE);
                                }


                                //  tWinner.setText(win+"Won the game.");


                            }

                        }


                    }*/


                    mBinding.buttonReset.setVisibility(View.VISIBLE);
                    mBinding.scoreText.setVisibility(View.VISIBLE);

                }
            }

            boolean check = true;

            for (int i = 0; i<gameState.length; i++){

                if (gameState[i] == 0){
                    check = false;

                }
            }

            if (check){

                Button playAgain = findViewById(R.id.button_reset);
                playAgain.setVisibility(View.VISIBLE);
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
        for (int i = 0; i<gameState.length; i++){
            gameState[i] = 0;
        }

    }

    public void PlayAgain(View view) {


    }


}

