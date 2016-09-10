package kettsuninc.android_dev_templete;

import android.app.Application;
import android.content.Context;

import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Provides;
import kettsuninc.android_dev_templete.model.api.interceptor.RequestInterceptor;
import kettsuninc.android_dev_templete.util.EnumTypeAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Modules for Dagger2.
 * There are some instances in this class.
 * Created by yuji on 16/09/11.
 */
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideAppApplicationContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpCilent() {
        return new OkHttpClient.Builder()
                .addInterceptor(new RequestInterceptor())
                .addInterceptor(new HttpLoggingInterceptor())
                .build();
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create(new GsonBuilder()
                .registerTypeAdapterFactory(new EnumTypeAdapterFactory())
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ")
                .excludeFieldsWithoutExposeAnnotation()
                .create());
    }

    @Provides
    @Singleton
    public RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory converterFactory, RxJavaCallAdapterFactory adapterFactory) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(App.getResString(R.string.api_end_point))
                .client(client)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .build();

        return retrofit;
    }


}
