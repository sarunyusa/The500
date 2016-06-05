package th.sarunyu.the500.http.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import th.sarunyu.the500.dao.PhotoItemCollectionDao;

/**
 * Created by Sarunyu on 4/6/2016.
 */
public interface The500pxApi {

    @GET("photos/search")
    Call<PhotoItemCollectionDao> loadPhotoByCategory(
            @Query("only") String only
            , @Query("consumer_key") String consumerKey
            , @Query("page") String page
            , @Query("sort") String sort
            , @Query("image_size") String size
    );

}
