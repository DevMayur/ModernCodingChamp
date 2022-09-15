package com.mayurkakade.moderncodingchamp.api.subtitles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubtitleResponseObject {

    @SerializedName("get_subtitles")
    @Expose
    private List<SubtitlePojo> getSubtitles = null;
    @SerializedName("num_of_subtitles")
    @Expose
    private Integer numOfSubtitles;
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;

    public List<SubtitlePojo> getGetSubtitles() {
        return getSubtitles;
    }

    public void setGetSubtitles(List<SubtitlePojo> getSubtitles) {
        this.getSubtitles = getSubtitles;
    }

    public Integer getNumOfSubtitles() {
        return numOfSubtitles;
    }

    public void setNumOfSubtitles(Integer numOfSubtitles) {
        this.numOfSubtitles = numOfSubtitles;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}