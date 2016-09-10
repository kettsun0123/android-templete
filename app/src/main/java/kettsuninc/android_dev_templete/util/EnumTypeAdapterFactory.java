package kettsuninc.android_dev_templete.util;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by yuji on 16/01/14.
 */
public class EnumTypeAdapterFactory implements TypeAdapterFactory {

    public <T> TypeAdapter<T> create(@NonNull Gson gson, @NonNull TypeToken<T> type) {
        Class<T> rawType = (Class<T>) type.getRawType();
        if (!rawType.isEnum()) {
            return null;
        }

        final Map<String, T> lowerCase = new HashMap<>();
        for (T constant : rawType.getEnumConstants()) {
            lowerCase.put(toLowerCase(constant), constant);
        }

        return new TypeAdapter<T>() {
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    out.value(toLowerCase(value));
                }
            }

            @Override
            public T read(JsonReader reader) throws IOException {
                if (reader.peek() == JsonToken.NULL) {
                    reader.nextNull();
                    return null;
                } else {
                    return lowerCase.get(reader.nextString());
                }
            }
        };
    }

    private String toLowerCase(@NonNull Object object) {
        return object.toString().toLowerCase(Locale.ENGLISH);
    }
}