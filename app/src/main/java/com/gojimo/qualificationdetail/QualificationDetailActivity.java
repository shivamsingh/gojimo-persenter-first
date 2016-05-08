package com.gojimo.qualificationdetail;

import android.support.v7.app.AppCompatActivity;

import com.gojimo.Fragments;
import com.gojimo.R;
import com.gojimo.entity.Qualification;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;

@EActivity(R.layout.container_activity)
public class QualificationDetailActivity extends AppCompatActivity {
    @Extra
    Qualification qualification;

    @AfterViews
    void init() {
        QualificationDetailFragment qualificationDetailFragment = QualificationDetailFragment_.builder()
                .qualification(qualification)
                .build();

        Fragments.loadContentFragment(this, R.id.container, qualificationDetailFragment);
    }
}
