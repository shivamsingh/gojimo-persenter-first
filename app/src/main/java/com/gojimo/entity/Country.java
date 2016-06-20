package com.gojimo.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Country implements Parcelable {
    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        @Override public Country[] newArray(int size) {
            return new Country[size];
        }
    };
    private String code;
    private String name;

    public Country() {
    }

    protected Country(Parcel in) {
        this.code = in.readString();
        this.name = in.readString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeString(this.name);
    }
}
