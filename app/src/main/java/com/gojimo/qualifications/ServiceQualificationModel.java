package com.gojimo.qualifications;

import com.gojimo.entity.Qualification;
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

    @Override
    public Observable<Qualification> qualification(String qualificationId) {
        return service.qualification(qualificationId);
    }
}
