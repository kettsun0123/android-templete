package kettsuninc.android_dev_templete.dao;

import kettsuninc.android_dev_templete.dao.api.LikeApi;
import kettsuninc.android_dev_templete.entity.LikeEntity;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yuji on 16/09/11.
 */
public class LikeDao extends AbstractDao<LikeApi> {

    public LikeDao(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    LikeApi getApi() {
        return mRetrofit.create(LikeApi.class);
    }

    public void like(String id) {
        Observable<LikeEntity> observable = getApi().like(id);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(likeEntity -> {

                });
    }

    public void dislike(String id) {
        Observable<LikeEntity> observable = getApi().dislike(id);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(likeEntity -> {

                });
    }
}
