package com.itechsofsolutions.tictactoe.ui.app.team;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.data.helper.Constants;
import com.itechsofsolutions.tictactoe.databinding.ActivityTeamSelectionBinding;
import com.itechsofsolutions.tictactoe.ui.app.home.HomeSelectionActivity;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;
import com.itechsoftsolution.ebay.utils.helper.SharedPrefUtils;

import org.jetbrains.annotations.NotNull;

public class TeamSelectionActivity extends BaseActivity<TeamSelectionMvpView,
        TeamSelectionPresenter> {

    private ActivityTeamSelectionBinding mBinding;
    private Boolean isButtonClicked = false;


    public static void runActivity(Activity mActivity) {
        mActivity.startActivity(new Intent(mActivity, TeamSelectionActivity.class));
    }


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_team_selection;
    }

    @NotNull
    @Override
    protected TeamSelectionPresenter getActivityPresenter() {
        return new TeamSelectionPresenter();
    }


    @Override
    protected void startUI() {

        mBinding = (ActivityTeamSelectionBinding) getViewDataBinding();
        // setClickListener();
        // playerShowData();
        setClickListener(mBinding.buttonPlayerX, mBinding.buttonPlayerO,
                 mBinding.buttonPlayerX2, mBinding.buttonPlayerO2,mBinding.buttonPlay);
    }

    @Override
    protected void stopUI() {

    }


    public void onClick(@NotNull View view) {

        switch (view.getId()) {

            case R.id.button_player_X:
                if (isButtonClicked) {
                    mBinding.buttonPlayerX.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                  //mBinding.buttonPlayerX.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary));
                    //SharedPrefUtils.INSTANCE.write(Constants.Prefernces.)
                } else {
                    checkableButton(mBinding.buttonPlayerX, mBinding.buttonPlayerO, mBinding.buttonPlayerX2);
                    mBinding.buttonPlayerX.setTextColor(Color.BLUE);
                   // mBinding.buttonPlayerX.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary));
                    isButtonClicked = true;
                }
                break;

            case R.id.button_player_O:
                if (isButtonClicked) {
                    mBinding.buttonPlayerO.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                } else {
                    checkableButton(mBinding.buttonPlayerX, mBinding.buttonPlayerO2, mBinding.buttonPlayerX2);
                    isButtonClicked = true;
                }
                break;

            case R.id.button_player_X_2:
                if (isButtonClicked) {
                    mBinding.buttonPlayerX2.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary));
                } else {
                    checkableButton(mBinding.buttonPlayerX2, mBinding.buttonPlayerO, mBinding.buttonPlayerX2);
                    isButtonClicked = true;
                }
                break;

            case R.id.button_player_O_2:
                if (isButtonClicked) {
                    mBinding.buttonPlayerO2.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary));
                } else {
                    checkableButton(mBinding.buttonPlayerO2, mBinding.buttonPlayerO,mBinding.buttonPlayerX2);
                    // mBinding.buttonPlayerO2.setTextColor(Color.GREEN);
                    mBinding.buttonPlayerO2.setBackgroundTintList(ContextCompat.
                            getColorStateList(this, R.color.colorPrimary));
                    isButtonClicked = true;
                }
                break;

            case R.id.button_play:
                SharedPrefUtils.INSTANCE.write(Constants.Prefernces.PLAYER_NAME_ONE,
                        mBinding.editTextP1.getText().toString().trim());
                SharedPrefUtils.INSTANCE.write(Constants.Prefernces.PLAYER_NAME_TWO,
                        mBinding.editTextP2.getText().toString().trim());

                Intent intent = new Intent(TeamSelectionActivity.this, HomeSelectionActivity.class);
                startActivity(intent);
                break;
        }

    }

    public void checkableButton(MaterialButton playerX, MaterialButton playerO,
                                MaterialButton player2X) {

        playerX.setBackgroundColor(Color.WHITE);
        //playerX.setBackgroundColor(getResources().getColor(R.color.colorAccent));
       // playerX.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.color_white));
        playerX.setEnabled(false);

        playerO.setEnabled(false);
        playerO.setAlpha(0.5f);

        player2X.setEnabled(false);
        player2X.setAlpha(0.5f);
    }

}
