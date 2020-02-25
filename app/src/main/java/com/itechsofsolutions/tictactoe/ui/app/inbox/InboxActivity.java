package com.itechsofsolutions.tictactoe.ui.app.inbox;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.itechsofsolutions.tictactoe.R;
import com.itechsofsolutions.tictactoe.databinding.ActivityInboxBinding;
import com.itechsofsolutions.tictactoe.ui.base.component.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class InboxActivity extends BaseActivity<InboxMvpView,InboxPresenter> {


    ActivityInboxBinding mBinding;
    public static InboxActivity inboxActivity;

    public static void runActivity(Activity mActivity){
        mActivity.startActivity(new Intent(mActivity, InboxActivity.class));

    }


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_inbox;
    }

    @NotNull
    @Override
    protected InboxPresenter getActivityPresenter() {
        return new InboxPresenter();
    }

    @Override
    protected void startUI() {

        mBinding = (ActivityInboxBinding) getViewDataBinding();
        inboxActivity = this;
        inItClickListener();


    }

    @Override
    protected void stopUI() {

    }

    public void inItClickListener(){
        setClickListener(mBinding.textViewFriend,mBinding.textViewRecentChat);
    }

    @Override
    public void onClick(@NotNull View view) {
        super.onClick(view);

    }
}
