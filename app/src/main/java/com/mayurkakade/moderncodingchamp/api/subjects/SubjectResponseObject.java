package com.mayurkakade.moderncodingchamp.api.subjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubjectResponseObject {

    @SerializedName("get_subject")
    @Expose
    public List<SubjectPojo> getSubject = null;
    @SerializedName("num_of_subjects")
    @Expose
    public Integer numOfSubjects;
    @SerializedName("success")
    @Expose
    public String success;
    @SerializedName("message")
    @Expose
    public String message;

}