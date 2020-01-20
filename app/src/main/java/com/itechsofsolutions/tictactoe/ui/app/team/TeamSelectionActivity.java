package com.itechsofsolutions.tictactoe.ui.app.team;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.ActivityTeamSelectionBinding;
import com.itechsofsolutions.tictactoe.ui.app.home.HomeActivity;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;
import com.itechsofsolutions.tictactoe.utils.helper.Constants;
import com.itechsoftsolution.ebay.utils.helper.SharedPrefUtils;

import org.jetbrains.annotations.NotNull;


public class TeamSelectionActivity extends BaseActivity<TeamSelectionMvpView,
        TeamSelectionPresenter> {

    /*// private  mBinding;
    private String name = "";
    private Button btnPlay;
    private EditText editTextPlayerOne, editTextPlayerTwo;*/
    private Button buttonPlay;

    private ActivityTeamSelectionBinding mBinding;

    //lst
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
        inItViews();

        if (SharedPrefUtils.INSTANCE.readBoolean(Constants.PreferenceKeys.IS_SOCIAL_LOGIN)){
            mBinding.editTextP1.setVisibility(View.INVISIBLE);
            mBinding.buttonO.setVisibility(View.INVISIBLE);
        }
        setClickListener();



        mBinding.buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeamSelectionActivity.this,
                        HomeActivity.class);
                //intent.putExtra("playeronename", editTextPlayerOne.getText().toString());
                //intent.putExtra("playertwoname", editTextPlayerTwo.getText().toString());
                startActivity(intent);
            }
        });





        /*buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeamSelectionActivity.this, HomeActivity.class);
                intent.putExtra("playeronename", editTextPlayerOne.getText().toString());
                intent.putExtra("playertwoname", editTextPlayerTwo.getText().toString());
                startActivity(intent);

            }
        });*/

    }

    @Override
    protected void stopUI() {

    }

    private void inItViews() {

       /* GlideUtils.Companion.glideWithPeople(mBinding.imageViewProfile,
                SharedPrefUtils.INSTANCE.readString(Constants.PreferenceKeys.USER_IMAGE,""));
        mBinding.editTextP1.setEnabled(false);
        mBinding.editTextP2.setEnabled(false);
        mBinding.buttonX.setClickable(false);
        mBinding.buttonX2.setClickable(false);
        mBinding.buttonO.setClickable(false);
        mBinding.buttonO2.setClickable(false);*/

       /* editTextPlayerOne = findViewById(R.id.edit_text_p1);
        editTextPlayerTwo = findViewById(R.id.edit_text_p2);
        buttonPlay = findViewById(R.id.button_play);*/

    }


}
