package com.gojimo.qualifications;

import android.support.v7.app.AppCompatActivity;

import com.gojimo.Fragments;
import com.gojimo.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import static com.gojimo.network.GojimoRestClient.service;

@EActivity(R.layout.container_activity)
public class QualificationActivity extends AppCompatActivity {

    @AfterViews
    void init() {
        QualificationFragment qualificationFragment = QualificationFragment_.builder().build();
        Fragments.loadContentFragment(this, R.id.container, qualificationFragment);

        new QualificationsPresenter(new ServiceQualificationModel(service()), qualificationFragment);
    }

}
