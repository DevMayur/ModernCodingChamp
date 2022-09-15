package com.mayurkakade.moderncodingchamp.api;

import com.mayurkakade.moderncodingchamp.api.content.ContentResponseObject;
import com.mayurkakade.moderncodingchamp.api.subjects.SubjectResponseObject;
import com.mayurkakade.moderncodingchamp.api.subtitles.SubtitleResponseObject;
import com.mayurkakade.moderncodingchamp.api.titles.TitlesResponseObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPI {

    @GET("?type=subjects")
    Call<SubjectResponseObject> getSubject();

    @GET("?type=titles")
    Call<TitlesResponseObject> getTitles(@Query("subject_id") String subjectId);

    @GET("?type=subtitles")
    Call<SubtitleResponseObject> getSubtitles(@Query("title_id") String titleId);

    @GET("?type=content")
    Call<ContentResponseObject> getContent(@Query("subtitle_id") String subtitleId);
}
