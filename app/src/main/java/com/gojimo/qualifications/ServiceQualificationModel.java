package com.gojimo.qualifications;

import java.util.List;

import rx.Observable;

public class ServiceQualificationModel implements QualificationModel {

    public ServiceQualificationModel() {
    }

    @Override
    public Observable<List<Qualification>> qualifications() {
        return null;
    }
}
