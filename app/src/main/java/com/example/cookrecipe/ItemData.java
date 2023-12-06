package com.example.cookrecipe;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemData implements Parcelable {
    public String itemImage;
    public String itemLabel;
    public String itemCalories;
    public String itemIngredients;
    public String itemFats;
    public String itemSugars;
    public String itemProteins;
    public String itemCarbs;

    public ItemData(String itemImage, String itemLabel, String itemCalories, String itemIngredients, String itemFats,String itemSugars, String itemProteins, String itemCarbs) {
        this.itemImage = itemImage;
        this.itemLabel = itemLabel;
        this.itemCalories = itemCalories;
        this.itemIngredients = itemIngredients;
        this.itemFats = itemFats;
        this.itemSugars = itemSugars;
        this.itemProteins = itemProteins;
        this.itemCarbs = itemCarbs;
    }

    protected ItemData(Parcel in) {
        itemImage = in.readString();
        itemLabel = in.readString();
        itemCalories = in.readString();
        itemIngredients = in.readString();
        itemFats = in.readString();
        itemSugars = in.readString();
        itemProteins = in.readString();
        itemCarbs = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemImage);
        dest.writeString(itemLabel);
        dest.writeString(itemCalories);
        dest.writeString(itemIngredients);
        dest.writeString(itemFats);
        dest.writeString(itemSugars);
        dest.writeString(itemProteins);
        dest.writeString(itemCarbs);
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
