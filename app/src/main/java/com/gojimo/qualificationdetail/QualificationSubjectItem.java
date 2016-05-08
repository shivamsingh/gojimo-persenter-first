package com.gojimo.qualificationdetail;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gojimo.BaseListItemView;
import com.gojimo.R;
import com.gojimo.entity.Subject;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.qualification_subject_item)
public class QualificationSubjectItem extends RelativeLayout implements BaseListItemView<Subject> {
    @ViewById(R.id.indicator)
    protected View indicator;

    @ViewById(R.id.title)
    protected TextView title;

    public QualificationSubjectItem(Context context) {
        super(context);
    }

    @Override
    public void bind(Subject subject) {
        title.setText(subject.getTitle());
        if (subject.getColour() != null && !subject.getColour().equalsIgnoreCase(""))
            indicator.setBackgroundColor(Color.parseColor(subject.getColour()));
        else
            indicator.setBackgroundColor(Color.WHITE);
    }
}
