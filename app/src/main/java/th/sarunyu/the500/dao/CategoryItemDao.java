package th.sarunyu.the500.dao;

/**
 * Created by Sarunyu on 4/6/2016.
 */
public class CategoryItemDao {

    private String categoryId;
    private String categoryName;
    private String categoryLabel;

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
}
