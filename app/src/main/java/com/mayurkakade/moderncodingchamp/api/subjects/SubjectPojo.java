package com.mayurkakade.moderncodingchamp.api.subjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubjectPojo {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("subject")
    @Expose
    public String title;

}