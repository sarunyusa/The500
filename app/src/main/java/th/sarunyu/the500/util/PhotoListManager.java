package th.sarunyu.the500.util;

import android.content.Context;


import th.sarunyu.the500.dao.PhotoItemCollectionDao;

/**
 * Created by Sarunyu on 5/6/2016.
 */
public class PhotoListManager {

    private int currenPage = 0;
    private PhotoItemCollectionDao dao;

    public PhotoItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(PhotoItemCollectionDao dao) {
        this.dao = dao;
    }

    public int getCurrenPage() {
        return currenPage;
    }

    public void setCurrenPage(int currenPage) {
        this.currenPage = currenPage;
    }

    public void insertDaoAtToPosition(PhotoItemCollectionDao newDao){
        // TODO : Clear unuse code before complete
//        if(dao==null) dao = new PhotoItemCollectionDao();
//        if(dao.getPhotos()==null) dao.setPhotos(new ArrayList<Photo>());
//
//        dao.getData().addAll(0,newDao.getData());

    }

    private Context mContext;

    public PhotoListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public int getMaximumId(){
        // TODO : Clear unuse code before complete
//        if(dao==null) return 0;
//        if(dao.getData()==null) return 0;
//        if(dao.getData().size() == 0) return 0;
//
//        int maxId = dao.getData().get(0).getId();
//
//        for(int i=1;i<dao.getData().size();i++){
//            maxId = Math.max(maxId, dao.getData().get(i).getId());
//        }
//        return maxId;
        return 0;
    }

    public int getCount(){
        // TODO : Clear unuse code before complete
        if(dao==null) return 0;
//        if(dao.getPhotos()==null) return 0;
//
//        return dao.getPhotos().size();
        return 0;
    }

}
