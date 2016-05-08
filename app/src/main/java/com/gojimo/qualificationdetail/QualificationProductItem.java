package com.gojimo.qualificationdetail;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gojimo.BaseListItemView;
import com.gojimo.R;
import com.gojimo.entity.Product;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.qualification_product_item)
public class QualificationProductItem extends RelativeLayout implements BaseListItemView<Product> {
    @ViewById(R.id.title)
    protected TextView title;

    @ViewById(R.id.author)
    protected TextView author;

    @ViewById(R.id.total_asset)
    protected TextView totalAssets;

    public QualificationProductItem(Context context) {
        super(context);
    }

    @Override
    public void bind(Product product) {
        title.setText(product.getTitle());
        author.setText(product.getAuthor());
        totalAssets.setText("");
        if (!product.getAssets().isEmpty())
            totalAssets.setText(product.getAssets().size() + " Assets");
    }
}
