package com.gojimo.qualifications;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class QualificationsPresenter {
    public QualificationsPresenter(QualificationModel model, QualificationView view) {
        view.whenLoadQualifications().subscribe(ignored -> model.qualifications()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(view::showQualifications, view::error));
    }
}
