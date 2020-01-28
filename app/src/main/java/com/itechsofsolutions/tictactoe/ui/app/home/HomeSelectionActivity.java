package com.itechsofsolutions.tictactoe.ui.app.home;

import android.app.Activity;
import android.content.Intent;
import androidx.recyclerview.widget.GridLayoutManager;
import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.data.local.model.GameModel;
import com.itechsofsolutions.tictactoe.databinding.ActivityHomeBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;
import com.itechsofsolutions.tictactoe.utils.libs.ToastUtils;
import com.itechsoftsolution.ebay.utils.helper.SharedPrefUtils;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

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



        List<GameModel> modelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            modelList.add(new GameModel());

        }

        mAdapter = new GameAdapter(this);
        mBinding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mBinding.recyclerView.setAdapter(mAdapter);
        mAdapter.setListener(this);
        mAdapter.addItems(modelList);

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

        if (item != null) {

            if (position == 0) {
                if (item.getItemText().equals("X")) {
                    gPlay[0][0] = 1;
                } else {
                    gPlay[0][0] = 0;
                }

            } else if (position == 1) {
                if (item.getItemText().equals("X")) {
                    gPlay[0][1] = 1;
                } else {
                    gPlay[0][1] = 0;
                }

            } else if (position == 2) {
                if (item.getItemText().equals("X")) {
                    gPlay[0][2] = 1;
                } else {
                    gPlay[0][2] = 0;
                }

            } else if (position == 3) {
                if (item.getItemText().equals("X")) {
                    gPlay[1][0] = 1;
                } else {
                    gPlay[1][0] = 0;
                }

            } else if (position == 4) {
                if (item.getItemText().equals("X")) {
                    gPlay[1][1] = 1;
                } else {
                    gPlay[1][1] = 0;
                }

            } else if (position == 5) {
                if (item.getItemText().equals("X")) {
                    gPlay[1][2] = 1;
                } else {
                    gPlay[1][2] = 0;
                }

            } else if (position == 6) {
                if (item.getItemText().equals("X")) {
                    gPlay[2][0] = 1;
                } else {
                    gPlay[2][0] = 0;
                }

            } else if (position == 7) {
                if (item.getItemText().equals("X")) {
                    gPlay[2][1] = 1;
                } else {
                    gPlay[2][2] = 0;
                }

            } else if (position == 8) {
                if (item.getItemText().equals("X")) {
                    gPlay[2][2] = 1;
                } else {
                    gPlay[2][2] = 0;
                }
            }

        }
        checkMatePlayerOne();
        checkMatePlayerTwo();
    }

    public void checkMatePlayerOne() {

        if ((gPlay[0][0] == 1 && gPlay[0][1] == 1 && gPlay[0][2] == 1) ||
                (gPlay[1][0] == 1 && gPlay[1][1] == 1 && gPlay[1][2] == 1) ||
                (gPlay[2][0] == 1 && gPlay[2][1] == 1 && gPlay[2][2] == 1) ||
                (gPlay[0][0] == 1 && gPlay[1][0] == 1 && gPlay[2][0] == 1) ||
                (gPlay[0][1] == 1 && gPlay[1][1] == 1 && gPlay[2][1] == 1) ||
                (gPlay[0][2] == 1 && gPlay[1][2] == 1 && gPlay[2][2] == 1) ||
                (gPlay[0][0] == 1 && gPlay[1][1] == 1 && gPlay[2][2] == 1) ||
                (gPlay[2][0] == 1 && gPlay[1][1] == 1 && gPlay[0][2] == 1)) {

            ToastUtils.INSTANCE.success("Player One Win the match.");
        }


    }

    public void checkMatePlayerTwo() {

        if ((gPlay[0][0] == 0 && gPlay[0][1] == 0 && gPlay[0][2] == 0) ||
                (gPlay[1][0] == 0 && gPlay[1][1] == 0 && gPlay[1][2] == 0) ||
                (gPlay[2][0] == 0 && gPlay[2][1] == 0 && gPlay[2][2] == 0) ||
                (gPlay[0][0] == 0 && gPlay[1][0] == 0 && gPlay[2][0] == 0) ||
                (gPlay[0][1] == 0 && gPlay[1][1] == 0 && gPlay[2][1] == 0) ||
                (gPlay[0][2] == 0 && gPlay[1][2] == 0 && gPlay[2][2] == 0) ||
                (gPlay[0][0] == 0 && gPlay[1][1] == 0 && gPlay[2][2] == 0) ||
                (gPlay[2][0] == 0 && gPlay[1][1] == 0 && gPlay[0][2] == 0)) {

            ToastUtils.INSTANCE.success("Player Two win the match..");

        }


    }

}

