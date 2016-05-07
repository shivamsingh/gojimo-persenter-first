package com.gojimo.qualifications;

import android.content.Context;
import android.widget.RelativeLayout;

import com.gojimo.BaseListItemView;
import com.gojimo.R;

import org.androidannotations.annotations.EViewGroup;

@EViewGroup(R.layout.qualification_item)
public class QualificationItem extends RelativeLayout implements BaseListItemView<Qualification> {
    public QualificationItem(Context context) {
        super(context);
    }

    @Override
    public void bind(Qualification item) {
    }
}
