package com.gojimo.qualifications;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gojimo.Fragments;
import com.gojimo.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import static com.gojimo.network.GojimoRestClient.service;

@EActivity(R.layout.qualifications_activity)
public class QualificationActivity extends AppCompatActivity {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @AfterViews
    void initToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
    }

    @AfterViews
    void init() {
        QualificationFragment qualificationFragment = QualificationFragment_.builder().build();
        Fragments.loadContentFragment(this, R.id.container, qualificationFragment);

        new QualificationsPresenter(new ServiceQualificationModel(service()), qualificationFragment);
    }

}
