package com.ale.abcapiimplementation.entity;

import jakarta.persistence.Table;
@Table(name = "AbcInformationContent")
public class AbcInformationContent {

    private int _id;
    private String index;
    private String pubdateunix;
    private String _type;
    private String feedname;
    private String creator;
    private String imageresizer;
    private String promo_image;
    private String pubdate;
    private String link;
    private String image;
    private String title;
    private String description;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPubdateunix() {
        return pubdateunix;
    }

    public void setPubdateunix(String pubdateunix) {
        this.pubdateunix = pubdateunix;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String getFeedname() {
        return feedname;
    }

    public void setFeedname(String feedname) {
        this.feedname = feedname;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getImageresizer() {
        return imageresizer;
    }

    public void setImageresizer(String imageresizer) {
        this.imageresizer = imageresizer;
    }

    public String getPromo_image() {
        return promo_image;
    }

    public void setPromo_image(String promo_image) {
        this.promo_image = promo_image;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AbcInformationContent{" +
                "pubdate='" + pubdate + '\'' +
                ", link='" + link + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}