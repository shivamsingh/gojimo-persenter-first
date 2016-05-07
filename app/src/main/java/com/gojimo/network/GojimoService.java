package com.gojimo.network;

import com.gojimo.qualifications.Qualification;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GojimoService {
    @GET("/qualifications")
    Observable<List<Qualification>> qualifications();

    @GET("/qualifications/{qualification_id}")
    Observable<Qualification> qualification(@Path("qualification_id") String id);
}
