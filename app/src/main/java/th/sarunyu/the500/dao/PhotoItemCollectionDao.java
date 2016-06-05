package th.sarunyu.the500.dao;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import th.sarunyu.the500.dao.photoitem.Photo;

public class PhotoItemCollectionDao {

    @SerializedName("current_page") private int currentPage;
    @SerializedName("photos") private ArrayList<Photo> photos;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }

}
