package com.interview.zef.belfricsapi.apiexecutor;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.interview.zef.belfricsapi.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zef on 28/12/17.
 */

public class RetrofitClient {
    private static final String BASE_URL ="http://198.12.152.211/";
    private static Service service;



    public static Service getClient() {
        if (service == null) {
            Gson gson = new GsonBuilder()
                    .create();

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();

            service = retrofit.create(Service.class);
        }
        return service;
    }
}