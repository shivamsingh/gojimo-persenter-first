package com.gojimo.network;

import com.gojimo.entity.Qualification;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GojimoService {
    @GET("/api/v4/qualifications")
    Observable<List<Qualification>> qualifications();

    @GET("/api/v4/qualifications/{qualification_id}")
    Observable<Qualification> qualification(@Path("qualification_id") String id);
}
