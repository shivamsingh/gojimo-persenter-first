package com.gojimo.qualificationdetail;

import com.gojimo.qualifications.QualificationModel;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class QualificationDetailPresenter {
    public QualificationDetailPresenter(QualificationModel model, QualificationDetailView view) {
        view.initialized().subscribe(qualificationId -> model.qualification(qualificationId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(view::showQualification, view::error));
    }
}
