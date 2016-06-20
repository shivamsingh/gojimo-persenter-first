package com.gojimo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class Product implements Parcelable {
    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override public Product[] newArray(int size) {
            return new Product[size];
        }
    };
    private String id;
    private String title;
    private String link;
    private String type;
    private List<Asset> assets;
    private Publisher publisher;
    private String author;

    public Product() {
    }

    protected Product(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.link = in.readString();
        this.type = in.readString();
        this.assets = in.createTypedArrayList(Asset.CREATOR);
        this.publisher = in.readParcelable(Publisher.class.getClassLoader());
        this.author = in.readString();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
        dest.writeString(this.type);
        dest.writeTypedList(assets);
        dest.writeParcelable(this.publisher, flags);
        dest.writeString(this.author);
    }
}
