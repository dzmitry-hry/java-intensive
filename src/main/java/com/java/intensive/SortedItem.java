package com.java.intensive;

public class SortedItem{
    public String str;
    public int index;

    public SortedItem(String str, int index) {
        this.str = str;
        this.index = index;
    }

    public String getStr() {
        return str;
    }

    public int getIndex() {
        return index;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return str + " - " + index;
    }
}