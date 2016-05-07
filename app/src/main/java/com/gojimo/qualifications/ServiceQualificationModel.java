package com.gojimo.qualifications;

import com.gojimo.network.GojimoService;

import java.util.List;

import rx.Observable;

public class ServiceQualificationModel implements QualificationModel {
    private GojimoService service;

    public ServiceQualificationModel(GojimoService service) {
        this.service = service;
    }

    @Override
    public Observable<List<Qualification>> qualifications() {
        return service.qualifications();
    }
}