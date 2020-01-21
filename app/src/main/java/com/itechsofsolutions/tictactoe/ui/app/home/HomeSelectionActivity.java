package com.itechsofsolutions.tictactoe.ui.app.home;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class HomeSelectionActivity extends BaseActivity<HomeSelectionMvpView,
        HomeSelectionPresenter> {



   /* private TextView player1ScoreTV,player2ScoreTV;
    private Button resetBtn;
    private Button [][] btns = new Button[3][3];

    private int player1Points=0,player2Points=0;
    private int roundCount=0;
    private Boolean player1Tern=true;
    private String Player1Name,Player2Name;*/


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

        initViews();

        Player1Name=getIntent().getStringExtra("playeronename");
        Player2Name=getIntent().getStringExtra("playertwoname");
        player1ScoreTV.setText(Player1Name+"(X): 0");
        player2ScoreTV.setText(Player2Name+"(0): 0");

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBoard();
            }
        });

    }



    @Override
    protected void stopUI() {

    }


    private void initViews() {

        player1ScoreTV=findViewById(R.id.p1TV);
        player2ScoreTV=findViewById(R.id.p2TV);
        resetBtn=findViewById(R.id.resetBtn);

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                String id_name="btn_"+i+j; //btn_00 ,btn_01,btn_02
                int btnId=this.getResources().getIdentifier(id_name,"id",getPackageName());
                btns[i][j]=findViewById(btnId); //findViewById(R.id.btn_00);
               // btns[i][j].setOnClickListener(this);
            }
        }
    }

    private void resetBoard() {

        for (int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                btns[i][j].setText("");
                btns[i][j].setEnabled(true);
            }
        }
        roundCount=0;
        player1Tern=true;
    }
}

