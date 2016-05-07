package com.gojimo.qualifications;

import java.util.List;

import rx.Observable;

public interface QualificationModel {
    Observable<List<Qualification>> qualifications();
}
