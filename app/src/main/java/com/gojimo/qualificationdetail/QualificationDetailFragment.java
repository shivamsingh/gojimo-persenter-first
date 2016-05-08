package com.gojimo.qualificationdetail;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gojimo.BaseFragment;
import com.gojimo.CustomRecyclerAdapter;
import com.gojimo.DividerItemDecoration;
import com.gojimo.R;
import com.gojimo.entity.Qualification;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.qualification_detail)
public class QualificationDetailFragment extends BaseFragment {
    @FragmentArg
    Qualification qualification;

    @ViewById(R.id.qualification_details)
    RecyclerView qualificationDetails;

    CustomRecyclerAdapter qualificationDetailAdapter;

    @AfterViews
    void init() {
        qualificationDetails.addItemDecoration(new DividerItemDecoration(getActivity()));
        qualificationDetails.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        showQualification(qualification);
    }

    private void showQualification(Qualification qualification) {
        if (!qualification.getSubjects().isEmpty())
            qualificationDetailAdapter = new CustomRecyclerAdapter(qualification.getSubjects(), this::qualificationSubjectItem);
        else if (!qualification.getProducts().isEmpty())
            qualificationDetailAdapter = new CustomRecyclerAdapter(qualification.getProducts(), this::qualificationProductItem);
        else
            showNoQualificationDetail();
        qualificationDetails.setAdapter(qualificationDetailAdapter);
    }

    private void showNoQualificationDetail() {
    }

    private QualificationSubjectItem qualificationSubjectItem() {
        return QualificationSubjectItem_.build(getActivity());
    }

    private QualificationProductItem qualificationProductItem() {
        return QualificationProductItem_.build(getActivity());
    }
}
