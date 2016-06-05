package th.sarunyu.the500.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import th.sarunyu.the500.R;
import th.sarunyu.the500.dao.CategoryItemDao;

public class CategoryListItem extends FrameLayout {

    private TextView tvCategoryItemLabel;
    private CategoryItemDao dao;

    public CategoryListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public CategoryListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
    }

    public CategoryListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
    }

    @TargetApi(21)
    public CategoryListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
    }

    private void initInflate(){
        inflate(getContext(), R.layout.list_item_category, this);
    }

    private void initInstances(){
        tvCategoryItemLabel = (TextView) findViewById(R.id.tvCategoryItemLabel);
    }

    public void setCategoryItem(CategoryItemDao dao){
        this.dao = dao;
        tvCategoryItemLabel.setText(dao.getCategoryLabel());
    }
}
