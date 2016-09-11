package kettsuninc.android_dev_templete.dao;

import java.util.List;

import kettsuninc.android_dev_templete.dao.api.PostApi;
import kettsuninc.android_dev_templete.entity.PostEntity;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yuji on 16/09/11.
 */
public class PostDao extends AbstractDao<PostApi> {
    public PostDao(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    PostApi getApi() {
        return mRetrofit.create(PostApi.class);
    }

    public void getPosts(int dayOfWeek) {
        Observable<List<PostEntity>> observable = getApi().getPosts(dayOfWeek);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postEntities -> {
                   //ここにpostEntitiesを受け取った時の処理

                });
    }

    public void getPost(String id) {
        Observable<PostEntity> observable = getApi().getPost(id);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postEntity -> {
                   //ここにpostEntityを受け取った時の処理
                });
    }
}
