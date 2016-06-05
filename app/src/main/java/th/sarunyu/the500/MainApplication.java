package th.sarunyu.the500;

import android.app.Application;

import th.sarunyu.the500.util.Contextor;

/**
 * Created by Sarunyu on 4/6/2016.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //initialize here
        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
