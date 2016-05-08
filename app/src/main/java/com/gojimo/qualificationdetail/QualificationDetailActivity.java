package com.gojimo.qualificationdetail;

import android.support.v7.app.AppCompatActivity;

import com.gojimo.Fragments;
import com.gojimo.R;
import com.gojimo.qualifications.ServiceQualificationModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;

import static com.gojimo.network.GojimoRestClient.service;

@EActivity(R.layout.container_activity)
public class QualificationDetailActivity extends AppCompatActivity {
    @Extra
    String qualificationId;

    @AfterViews
    void init() {
        QualificationDetailFragment qualificationDetailFragment = QualificationDetailFragment_.builder()
                .qualificationId(qualificationId)
                .build();

        Fragments.loadContentFragment(this, R.id.container, qualificationDetailFragment);

        new QualificationDetailPresenter(new ServiceQualificationModel(service()), qualificationDetailFragment);
    }
}
