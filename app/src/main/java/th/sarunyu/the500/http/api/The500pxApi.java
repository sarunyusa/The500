package th.sarunyu.the500.http.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Sarunyu on 4/6/2016.
 */
public interface The500pxApi {

    @GET("photos/search?only={category}&consumer_key={consumer_key}")
    Call loadPhotoByCategory(@Path("category") String category
            , @Path("consumer_key") String consumerKey);

}
