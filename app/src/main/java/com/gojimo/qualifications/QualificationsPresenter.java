package com.gojimo.qualifications;

public class QualificationsPresenter {
    private QualificationModel model;
    private QualificationView view;

    public QualificationsPresenter(QualificationModel model, QualificationView view) {
        this.model = model;
        this.view = view;
        registerEvents();
    }

    private void registerEvents() {
        view.whenLoadQualifications().subscribe(ignored -> model.qualifications().
                subscribe(view::showQualifications, view::error));
    }
}
