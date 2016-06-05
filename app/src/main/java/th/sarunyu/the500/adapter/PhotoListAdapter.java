package th.sarunyu.the500.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import th.sarunyu.the500.dao.PhotoItemCollectionDao;
import th.sarunyu.the500.dao.photoitem.Photo;
import th.sarunyu.the500.view.PhotoListItem;

/**
 * Created by Sarunyu on 5/6/2016.
 */
public class PhotoListAdapter extends BaseAdapter {

    private PhotoItemCollectionDao dao;

    private int lastPosition = -1;

    public void setDao(PhotoItemCollectionDao dao) {
        this.dao = dao;
    }

    @Override
    public int getCount() {
        if(dao == null){
            return 0;
        }
        if(dao.getPhotos() == null){
            return 0;
        }
        return dao.getPhotos().size();
    }

    @Override
    public Object getItem(int position) {
        return dao.getPhotos().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PhotoListItem item;

        if (convertView != null) {
            item = (PhotoListItem) convertView;
        } else {
            item = new PhotoListItem(parent.getContext());
            Log.d("view create monitor","view created");
        }

        Photo dao = (Photo) getItem(position);
        item.setNameText(dao.getName());
        item.setDescrptionText("by " + dao.getUser().getUserName());
        item.setImageUrl(dao.getImageUrl());

        return item;

    }

}
