package com.mayurkakade.moderncodingchamp.api.content;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentResponseObject {

    @SerializedName("get_content")
    @Expose
    private List<ContentPojo> getContent = null;
    @SerializedName("num_of_content")
    @Expose
    private Integer numOfContent;
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;

    public List<ContentPojo> getGetContent() {
        return getContent;
    }

    public void setGetContent(List<ContentPojo> getContent) {
        this.getContent = getContent;
    }

    public Integer getNumOfContent() {
        return numOfContent;
    }

    public void setNumOfContent(Integer numOfContent) {
        this.numOfContent = numOfContent;
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