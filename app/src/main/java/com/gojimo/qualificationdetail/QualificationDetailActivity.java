package com.gojimo.qualificationdetail;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.gojimo.Fragments;
import com.gojimo.R;
import com.gojimo.entity.Qualification;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.qualification_detail_activity)
public class QualificationDetailActivity extends AppCompatActivity {
    @Extra
    Qualification qualification;

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @AfterViews
    void initToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout.setTitle(qualification.getName());
    }

    @AfterViews
    void init() {
        QualificationDetailFragment qualificationDetailFragment = QualificationDetailFragment_.builder()
                .qualification(qualification)
                .build();

        Fragments.loadContentFragment(this, R.id.container, qualificationDetailFragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
