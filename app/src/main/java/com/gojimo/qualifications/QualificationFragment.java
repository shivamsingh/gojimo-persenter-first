package com.gojimo.qualifications;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import com.gojimo.BaseFragment;
import com.gojimo.CustomRecyclerAdapter;
import com.gojimo.DividerItemDecoration;
import com.gojimo.R;
import com.gojimo.entity.Qualification;
import com.gojimo.qualificationdetail.QualificationDetailActivity_;
import java.util.List;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import rx.Observable;
import rx.subjects.PublishSubject;

@EFragment(R.layout.qualifications)
public class QualificationFragment extends BaseFragment implements QualificationView {
    PublishSubject<Void> loadQualifications = PublishSubject.create();

    @ViewById(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    @ViewById(R.id.qualifications)
    RecyclerView qualifications;

    CustomRecyclerAdapter qualificationAdapter;

    @AfterViews
    void init() {
        swipeRefresh.setColorSchemeResources(R.color.primary_dark);
        swipeRefresh.setOnRefreshListener(this::loadQualifications);
        qualifications.addItemDecoration(new DividerItemDecoration(getActivity()));
        showLoader();
        loadQualifications();
    }

    private void loadQualifications() {
        loadQualifications.onNext(null);
    }

    @Override
    public Observable<Void> whenLoadQualifications() {
        return bindObservable(loadQualifications.asObservable());
    }

    @Override
    public void showQualifications(List<Qualification> qualificationList) {
        hideLoader();
        swipeRefresh.setRefreshing(false);

        if (qualificationAdapter == null) {
            qualificationAdapter = new CustomRecyclerAdapter(qualificationList, this::qualificationItem);
            qualifications.setAdapter(qualificationAdapter);
        } else
            qualificationAdapter.setItems(qualificationList);
    }

    private QualificationItem qualificationItem(int position) {
        if (position == qualificationAdapter.getItemCount()) {

        }

        QualificationItem qualificationItem = QualificationItem_.build(getActivity());
        qualificationItem.qualificationSelected().subscribe(this::navigateQualificationDetailScreen);
        return qualificationItem;
    }

    private void navigateQualificationDetailScreen(Qualification qualification) {
        QualificationDetailActivity_.intent(getActivity())
                .qualification(qualification)
                .start();
    }

}
