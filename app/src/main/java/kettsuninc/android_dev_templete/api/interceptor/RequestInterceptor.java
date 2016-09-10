package kettsuninc.android_dev_templete.model.api.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yuji on 16/09/11.
 */
public class RequestInterceptor implements Interceptor {

    private static final String TAG = RequestInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
//        builder.addHeader(HEADER_KEY, headerValue);

        return chain.proceed(builder.build());
    }

}
