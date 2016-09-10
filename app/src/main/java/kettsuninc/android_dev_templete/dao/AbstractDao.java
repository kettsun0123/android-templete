package kettsuninc.android_dev_templete.model.dao;

import retrofit2.Retrofit;

/**
 * Created by yuji on 16/09/11.
 */
abstract public class AbstractDao<T> {
    Retrofit mRetrofit;

    public AbstractDao(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }

    abstract T getApi();
}
