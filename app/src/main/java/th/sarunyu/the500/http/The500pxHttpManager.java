package th.sarunyu.the500.http;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import th.sarunyu.the500.http.api.The500pxApi;
import th.sarunyu.the500.util.Contextor;

/**
 * Created by Sarunyu on 4/6/2016.
 */
public class The500pxHttpManager {
    private static The500pxHttpManager instance;

    public static The500pxHttpManager getInstance() {
        if (instance == null)
            instance = new The500pxHttpManager();
        return instance;
    }

    private Context mContext;
    private The500pxApi service;

    private The500pxHttpManager() {
        mContext = Contextor.getInstance().getContext();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.500px.com/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(The500pxApi.class);
    }

    public The500pxApi getService(){
        return service;
    }
}
