package com.itechsofsolutions.tictactoe.ui.app.home;

import android.widget.ImageView;

public class GameLogic {

    private static ImageView[] sBlocks;
    public static String sWinner;
    public static int sSet;
    public static final int CIRCLE = 0;
    public static final int CROSS = 1;


    public static boolean areSameIntSet(int first, int second, int third, int set){

        boolean value = sBlocks[first - 1].getId() == sBlocks[second - 1].getId()
                && sBlocks[second - 1].getId() == sBlocks[third - 1].getId();
        if (value){

            if (sBlocks[first - 1].getId() == CIRCLE){
                sWinner = "CIRCLE";
            }else {
                sWinner = "CROSS";
            }
        }
        return value;
    }

    public static boolean isCompleted(int position, ImageView[] blocks){
        GameLogic.sBlocks = blocks;
        boolean isComplete = false;

        switch (position){
            case 1:
                isComplete = areSameIntSet(1,2,3,1) ||
                        areSameIntSet(1,4,7,4) ||
                        areSameIntSet(1,5,9,7);
                break;


            case 2:
                isComplete = areSameIntSet(1,2,3,1) ||
                        areSameIntSet(2,5,8,5);
                break;


            case 3:
                isComplete = areSameIntSet(1,2,3,1)||
                        areSameIntSet(3,6,9,6) ||
                        areSameIntSet(3,5,7,8);

            case 4:
                isComplete = areSameIntSet(4,5,6,2) ||
                        areSameIntSet(1,4,7,4);
                break;


            case 5:
                isComplete = areSameIntSet(4,5,6,2)||
                        areSameIntSet(2,5,8,5)||
                        areSameIntSet(1,5,9,7)||
                        areSameIntSet(3,5,7,8);
                break;


            case 6:
                isComplete = areSameIntSet(4, 5, 6, 2) ||
                        areSameIntSet(3, 6, 9, 6);
                break;


            case 7:
                isComplete = areSameIntSet(7, 8, 9, 3) ||
                        areSameIntSet(1, 4, 7, 4) ||
                        areSameIntSet(3, 5, 7, 8);
                break;


            case 8:
                isComplete = areSameIntSet(7, 8, 9, 3) ||
                        areSameIntSet(2, 5, 8, 5);
                break;


            case 9:
                isComplete = areSameIntSet(7, 8, 9, 3) ||
                        areSameIntSet(3, 6, 9, 6) ||
                        areSameIntSet(1, 5, 9, 7);
                break;

        }

        return isComplete;

    }


}
