package th.sarunyu.the500.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import java.util.List;

import th.sarunyu.the500.R;
import th.sarunyu.the500.dao.CategoryItemDao;
import th.sarunyu.the500.view.CategoryListItem;

/**
 * Created by Sarunyu on 5/6/2016.
 */
public class CategoryListAdapter extends BaseAdapter {

    private List<CategoryItemDao> list;

    private int lastPosition = -1;

    public void setDao(List<CategoryItemDao> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        if(list == null){
            return 0;
        }

        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CategoryListItem item;

        if (convertView != null) {
            item = (CategoryListItem) convertView;
        } else {
            item = new CategoryListItem(parent.getContext());
        }

        CategoryItemDao dao = (CategoryItemDao) getItem(position);
        item.setCategoryItem(dao);

        return item;


    }


}
