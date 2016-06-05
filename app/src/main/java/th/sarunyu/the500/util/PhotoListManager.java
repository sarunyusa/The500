package th.sarunyu.the500.util;

import android.content.Context;


import th.sarunyu.the500.dao.PhotoItemCollectionDao;

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

    private Context mContext;

    public PhotoListManager() {
        mContext = Contextor.getInstance().getContext();
    }


}
