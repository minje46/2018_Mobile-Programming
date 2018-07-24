package com.example.kwak.android_study1;

/**
 * Created by KWAK on 2018-05-07.
 */

public class MonthItem {

    private int dayValue;

    public MonthItem() {

    }

    public MonthItem(int day) {
        dayValue = day;
    }

    public int getDay() {
        return dayValue;
    }

    public void setDay(int day) {
        this.dayValue = day;
    }
}
