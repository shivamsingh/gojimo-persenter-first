package com.gojimo.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Subject implements Parcelable {
    public static final Parcelable.Creator<Subject> CREATOR = new Parcelable.Creator<Subject>() {
        @Override public Subject createFromParcel(Parcel source) {
            return new Subject(source);
        }

        @Override public Subject[] newArray(int size) {
            return new Subject[size];
        }
    };
    private String id;
    private String title;
    private String link;
    private String colour;

    public Subject() {
    }

    protected Subject(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.link = in.readString();
        this.colour = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.link);
        dest.writeString(this.colour);
    }
}
