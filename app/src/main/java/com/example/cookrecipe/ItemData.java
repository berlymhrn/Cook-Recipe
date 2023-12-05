package com.example.cookrecipe;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemData implements Parcelable {
    public String itemImage;
    public String itemLabel;
    public String itemCalories;

    // Constructor
    public ItemData(String itemImage, String itemLabel, String itemCalories) {
        this.itemImage = itemImage;
        this.itemLabel = itemLabel;
        this.itemCalories = itemCalories;
    }

    // Parcelable implementation
    protected ItemData(Parcel in) {
        itemImage = in.readString();
        itemLabel = in.readString();
        itemCalories = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemImage);
        dest.writeString(itemLabel);
        dest.writeString(itemCalories);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemData> CREATOR = new Creator<ItemData>() {
        @Override
        public ItemData createFromParcel(Parcel in) {
            return new ItemData(in);
        }

        @Override
        public ItemData[] newArray(int size) {
            return new ItemData[size];
        }
    };
}
