package com.gojimo.qualifications;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gojimo.BaseListItemView;
import com.gojimo.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import rx.Observable;
import rx.subjects.PublishSubject;

@EViewGroup(R.layout.qualification_item)
public class QualificationItem extends LinearLayout implements BaseListItemView<Qualification> {
    private PublishSubject<Qualification> qualificationSelection = PublishSubject.create();

    @ViewById(R.id.title)
    protected TextView title;

    private Qualification qualification;

    public QualificationItem(Context context) {
        super(context);
    }

    @Click(R.id.item_container)
    protected void qualificationClicked() {
        qualificationSelection.onNext(qualification);
    }

    public Observable<Qualification> qualificationSelected() {
        return qualificationSelection.asObservable();
    }

    @Override
    public void bind(Qualification item) {
        qualification = item;
        title.setText(item.getName());
    }
}
