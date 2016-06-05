package th.sarunyu.the500.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import th.sarunyu.the500.R;

/**
 * Created by Sarunyu on 5/6/2016.
 */
public class PhotoListItem extends FrameLayout {

    private TextView tvName, tvDescription;
    private ImageView ivImg;

    public PhotoListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public PhotoListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
    }

    public PhotoListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
    }

    @TargetApi(21)
    public PhotoListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
    }

    private void initInflate() {
        inflate(getContext(), R.layout.list_item_photo, this);
    }

    private void initInstances() {
        // findViewById here
        tvName = (TextView) findViewById(R.id.tvName);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        ivImg = (ImageView) findViewById(R.id.ivImg);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width * 2 / 3;
        int newHeighMeasureSpec = MeasureSpec.makeMeasureSpec(
                height,
                MeasureSpec.EXACTLY
        );

        // Child views
        super.onMeasure(widthMeasureSpec, newHeighMeasureSpec);

        //Self
        setMeasuredDimension(width, height);

    }

    public void setNameText(String text) {
        tvName.setText(text);
    }

    public void setDescrptionText(String text) {
        tvDescription.setText(text);
    }

    public void setImageUrl(String url) {
        Glide.with(getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(ivImg);
    }

}
