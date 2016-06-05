package th.sarunyu.the500.util;

import android.content.Context;

/**
 * Created by Sarunyu on 4/6/2016.
 */
public class Contextor {

    private static Contextor instance;

    public static Contextor getInstance() {
        if (instance == null)
            instance = new Contextor();
        return instance;
    }

    private Context mContext;

    private Contextor() {

    }

    public void init(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

}
