package com.itechsofsolutions.tictactoe.data.local.model;

public class GameModel {

    private String itemText;
    private int itemImage;
    public  boolean isPressed;



    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }
}
