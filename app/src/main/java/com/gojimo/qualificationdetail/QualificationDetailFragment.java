package com.gojimo.qualificationdetail;

import com.gojimo.BaseFragment;
import com.gojimo.R;
import com.gojimo.entity.Qualification;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;

import rx.Observable;
import rx.subjects.PublishSubject;

@EFragment(R.layout.qualification_detail)
public class QualificationDetailFragment extends BaseFragment implements QualificationDetailView {
    private PublishSubject<String> initialization = PublishSubject.create();

    @FragmentArg
    String qualificationId;

    @AfterViews
    void init() {
        initialization.onNext(qualificationId);
    }

    @Override
    public Observable<String> initialized() {
        return bindObservable(initialization.asObservable());
    }

    @Override
    public void showQualification(Qualification qualification) {
    }
}
