package th.sarunyu.the500.dao;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Sarunyu on 4/6/2016.
 */
public class CategoryItemDao implements Parcelable {

    private String categoryId;
    private String categoryName;
    private String categoryLabel;

    protected CategoryItemDao(Parcel in) {
        categoryId = in.readString();
        categoryName = in.readString();
        categoryLabel = in.readString();
    }

    public static final Creator<CategoryItemDao> CREATOR = new Creator<CategoryItemDao>() {
        @Override
        public CategoryItemDao createFromParcel(Parcel in) {
            return new CategoryItemDao(in);
        }

        @Override
        public CategoryItemDao[] newArray(int size) {
            return new CategoryItemDao[size];
        }
    };

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public CategoryItemDao(){}

    public CategoryItemDao(String categoryId,String categoryName,String categoryLabel){
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryLabel = categoryLabel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categoryId);
        dest.writeString(categoryName);
        dest.writeString(categoryLabel);
    }
}
