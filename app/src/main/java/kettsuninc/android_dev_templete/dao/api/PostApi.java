package kettsuninc.android_dev_templete.dao.api;

import java.util.List;

import kettsuninc.android_dev_templete.entity.PostEntity;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yuji on 16/09/11.
 */
public interface PostApi {

    @GET("posts")
    Observable<List<PostEntity>> getPosts(
            @Query("dayOfWeek") int dayOfWeek
    );

    @GET("posts/{id}")
    Observable<PostEntity> getPost(
            @Path("id") String id
    );
}
