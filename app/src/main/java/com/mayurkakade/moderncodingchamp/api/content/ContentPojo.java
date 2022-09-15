package com.mayurkakade.moderncodingchamp.api.content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentPojo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("content_title")
    @Expose
    private String contentTitle;
    @SerializedName("content_text")
    @Expose
    private String contentText;
    @SerializedName("content_img")
    @Expose
    private String contentImg;
    @SerializedName("subtitle_id")
    @Expose
    private String subtitleId;
    @SerializedName("content_code")
    @Expose
    private String contentCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getContentImg() {
        return contentImg;
    }

    public void setContentImg(String contentImg) {
        this.contentImg = contentImg;
    }

    public String getSubtitleId() {
        return subtitleId;
    }

    public void setSubtitleId(String subtitleId) {
        this.subtitleId = subtitleId;
    }

    public String getContentCode() {
        return contentCode;
    }

    public void setContentCode(String contentCode) {
        this.contentCode = contentCode;
    }

}