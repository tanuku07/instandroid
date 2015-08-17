package kg.android.instagram.network;

import kg.android.instagram.model.Feed;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface Api {

    @GET("/users/self/feed")
    Observable<Feed> getFeed(@Query("max_id") String maxId);

}
