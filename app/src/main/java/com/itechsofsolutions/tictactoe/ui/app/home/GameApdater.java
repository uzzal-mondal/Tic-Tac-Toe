package com.itechsofsolutions.tictactoe.ui.app.home;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class GameApdater extends ArrayAdapter<GameLogic> {


    public GameApdater(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }
}
