package com.technawabs.openhouz.models;

public class GenericArrayItem {

    private String itemTitle;
    private String itemValue;

    public GenericArrayItem(String itemTitle, String itemValue) {
        this.itemTitle = itemTitle;
        this.itemValue = itemValue;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
}
