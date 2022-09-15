package com.mayurkakade.moderncodingchamp.api.titles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TitlesResponseObject {

    @SerializedName("get_titles")
    @Expose
    private List<TitlesPojo> getTitles = null;
    @SerializedName("num_of_titles")
    @Expose
    private Integer numOfTitles;
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;

    public List<TitlesPojo> getGetTitles() {
        return getTitles;
    }

    public void setGetTitles(List<TitlesPojo> getTitles) {
        this.getTitles = getTitles;
    }

    public Integer getNumOfTitles() {
        return numOfTitles;
    }

    public void setNumOfTitles(Integer numOfTitles) {
        this.numOfTitles = numOfTitles;
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
