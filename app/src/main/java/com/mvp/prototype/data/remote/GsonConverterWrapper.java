package com.mvp.prototype.data.remote;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class GsonConverterWrapper implements Converter {
    private GsonConverter converter;

    public GsonConverterWrapper(Gson gson) {
        this.converter = new GsonConverter(gson);
    }

    public Object fromBody(TypedInput body, Type type) throws ConversionException {
        byte[] bodyBytes = this.readInBytes(body);
        TypedByteArray newBody = new TypedByteArray(body.mimeType(), bodyBytes);

        try {
            return this.converter.fromBody(newBody, type);
        } catch (ConversionException var6) {
            if (var6.getCause() instanceof JsonParseException && type.equals(String.class)) {
                return new String(bodyBytes);
            } else {
                throw var6;
            }
        }
    }

    public TypedOutput toBody(Object object) {
        return this.converter.toBody(object);
    }

    private byte[] readInBytes(TypedInput body) throws ConversionException {
        InputStream in = null;

        try {
            in = body.in();
            ByteArrayOutputStream e = new ByteArrayOutputStream();
            byte[] buffer = new byte['\uffff'];

            int len;
            while ((len = in.read(buffer)) != -1) {
                e.write(buffer, 0, len);
            }

            e.flush();
            byte[] len1 = e.toByteArray();
            return len1;
        } catch (IOException var14) {
            throw new ConversionException(var14);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException var13) {
                }
            }

        }
    }
}
