package com.gojimo.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Qualification implements Parcelable {
    private String id;
    private String name;
    private Country country;
    private List<Subject> subjects;
    private String link;
    @SerializedName("default_products")
    private List<Product> products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeParcelable(this.country, flags);
        dest.writeList(this.subjects);
        dest.writeString(this.link);
        dest.writeList(this.products);
    }

    public Qualification() {
    }

    protected Qualification(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.country = in.readParcelable(Country.class.getClassLoader());
        this.subjects = new ArrayList<Subject>();
        in.readList(this.subjects, Subject.class.getClassLoader());
        this.link = in.readString();
        this.products = new ArrayList<Product>();
        in.readList(this.products, Product.class.getClassLoader());
    }

    public static final Parcelable.Creator<Qualification> CREATOR = new Parcelable.Creator<Qualification>() {
        @Override
        public Qualification createFromParcel(Parcel source) {
            return new Qualification(source);
        }

        @Override
        public Qualification[] newArray(int size) {
            return new Qualification[size];
        }
    };
}
