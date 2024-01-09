package com.ale.abcapiimplementation.entity;

import jakarta.persistence.Table;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
@Table(name = "AbcInformationContent")
public class AbcInformationContent {

    private String requestedText;
    private LocalDateTime date = LocalDateTime.now();
    private String newsUrl;
    private String newsPhotoUrl;
    private String newsTitle;
    private String newsResume;
//    String photoContentInBase64;      Para el bono
//    String newsPhotoContentType;      Para el bono

    public AbcInformationContent(String url, String photourl, String title, String resume){
        this.newsUrl = url;
        this.newsPhotoUrl = photourl;
        this.newsTitle = title;
        this.newsResume = resume;
    }

    public String getRequestedText() {
        return requestedText;
    }

    public void setRequestedText(String requestedText) {
        this.requestedText = requestedText;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(date);
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public String getNewsPhotoUrl() {
        return newsPhotoUrl;
    }

    public void setNewsPhotoUrl(String newsPhotoUrl) {
        this.newsPhotoUrl = newsPhotoUrl;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsResume() {
        return newsResume;
    }

    public void setNewsResume(String newsResume) {
        this.newsResume = newsResume;
    }

    @Override
    public String toString() {
        return requestedText;
    }
}
