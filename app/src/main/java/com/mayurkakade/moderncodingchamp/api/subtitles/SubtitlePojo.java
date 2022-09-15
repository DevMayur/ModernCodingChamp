package com.mayurkakade.moderncodingchamp.api.subtitles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SubtitlePojo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("subtitle_name")
    @Expose
    private String subtitleName;
    @SerializedName("title_id")
    @Expose
    private String titleId;
    @SerializedName("content_1")
    @Expose
    private String content1;
    @SerializedName("content_2")
    @Expose
    private String content2;
    @SerializedName("content_3")
    @Expose
    private String content3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubtitleName() {
        return subtitleName;
    }

    public void setSubtitleName(String subtitleName) {
        this.subtitleName = subtitleName;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

}