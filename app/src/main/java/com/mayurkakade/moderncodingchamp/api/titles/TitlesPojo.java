package com.mayurkakade.moderncodingchamp.api.titles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TitlesPojo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("no_of_subtitles")
    @Expose
    private String noOfSubtitles;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("subject_id")
    @Expose
    private String subjectId;

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

    public String getNoOfSubtitles() {
        return noOfSubtitles;
    }

    public void setNoOfSubtitles(String noOfSubtitles) {
        this.noOfSubtitles = noOfSubtitles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

}