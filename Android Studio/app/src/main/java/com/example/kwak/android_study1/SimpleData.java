package com.example.kwak.android_study1;

/**
 * Created by KWAK on 2018-04-03.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable{

    int number;
    String message;
    //Constructor
    public SimpleData(int num, String msg){
        number = num;
        message = msg;
    }
    //Parcel 객체에서 읽기.
    public SimpleData(Parcel src){
        number = src.readInt();
        message = src.readString();
    }
    //Creator interface를 익명 참조로 구현. (CREATOR 상수 정의) <- 무조건 해야한다.
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        //Type에 따른 return 구분 인듯.
        public SimpleData createFromParcel(Parcel in){
            return new SimpleData(in);  // Simpledata의 constructor를 호출해 Parcel객체에서 읽기.
        }

        public SimpleData[] newArray(int size){
            return new SimpleData[size];
        }
    };

    public int describeContents(){
        return 0;
    }
    // Parcel 객체로 쓰기.
    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(number);
        dest.writeString(message);
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }
}

