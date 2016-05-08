package com.gojimo.qualifications;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gojimo.BaseListItemView;
import com.gojimo.R;
import com.gojimo.entity.Qualification;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import rx.Observable;
import rx.subjects.PublishSubject;

@EViewGroup(R.layout.qualification_item)
public class QualificationItem extends RelativeLayout implements BaseListItemView<Qualification> {
    private PublishSubject<Qualification> qualificationSelection = PublishSubject.create();

    @ViewById(R.id.name)
    protected TextView name;

    @ViewById(R.id.country)
    protected TextView country;

    @ViewById(R.id.total_subject)
    protected TextView totalSubjects;

    @ViewById(R.id.total_products)
    protected TextView totalProducts;

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
        resetItem();

        name.setText(item.getName());
        if (qualification.getCountry() != null)
            country.setText(qualification.getCountry().getName());
        if (!qualification.getSubjects().isEmpty())
            totalSubjects.setText(qualification.getSubjects().size() + " Subjects");
        if (!qualification.getProducts().isEmpty())
            totalProducts.setText(qualification.getProducts().size() + " Products");
    }

    private void resetItem() {
        country.setText("");
        totalSubjects.setText("");
        totalProducts.setText("");
    }
}
