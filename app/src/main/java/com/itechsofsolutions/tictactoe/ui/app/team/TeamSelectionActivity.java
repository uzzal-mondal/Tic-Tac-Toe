package com.itechsofsolutions.tictactoe.ui.app.team;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.ActivityTeamSelectionBinding;
import com.itechsofsolutions.tictactoe.ui.app.home.HomeSelectionActivity;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class TeamSelectionActivity extends BaseActivity<TeamSelectionMvpView,
        TeamSelectionPresenter> {

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
        setClickListener();
        mBinding.buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeamSelectionActivity.this,
                        HomeSelectionActivity.class);
                intent.putExtra("playeronename", mBinding.editTextP1.getText().toString());
                intent.putExtra("playertwoname", mBinding.editTextP2.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void stopUI() {

    }


}
