package com.gojimo.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Asset implements Parcelable {
    public static final Parcelable.Creator<Asset> CREATOR = new Parcelable.Creator<Asset>() {
        @Override public Asset createFromParcel(Parcel source) {
            return new Asset(source);
        }

        @Override public Asset[] newArray(int size) {
            return new Asset[size];
        }
    };
    private String id;
    private String contentType;
    private String path;
    private String link;

    public Asset() {
    }

    protected Asset(Parcel in) {
        this.id = in.readString();
        this.contentType = in.readString();
        this.path = in.readString();
        this.link = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.contentType);
        dest.writeString(this.path);
        dest.writeString(this.link);
    }
}
