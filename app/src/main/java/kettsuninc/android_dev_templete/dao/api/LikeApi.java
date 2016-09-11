package kettsuninc.android_dev_templete.dao.api;


import kettsuninc.android_dev_templete.entity.LikeEntity;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yuji on 16/09/11.
 */
public interface LikeApi {

    @POST("like/{id}")
    Observable<LikeEntity> like(
            @Path("id") String id
    );

    @DELETE("like/{id}")
    Observable<LikeEntity> dislike(
            @Path("id") String id
    );
}
