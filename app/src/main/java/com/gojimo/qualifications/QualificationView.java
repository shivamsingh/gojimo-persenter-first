package com.gojimo.qualifications;

import com.gojimo.BaseView;
import com.gojimo.entity.Qualification;

import java.util.List;

import rx.Observable;

public interface QualificationView extends BaseView {
    Observable<Void> whenLoadQualifications();

    void showQualifications(List<Qualification> qualifications);
}
