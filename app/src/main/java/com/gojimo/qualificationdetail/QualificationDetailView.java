package com.gojimo.qualificationdetail;

import com.gojimo.BaseView;
import com.gojimo.entity.Qualification;

import rx.Observable;

public interface QualificationDetailView extends BaseView{
    Observable<String> initialized();

    void showQualification(Qualification qualification);
}
