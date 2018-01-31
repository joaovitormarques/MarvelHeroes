package com.example.joaovitor.shared.network;

import com.example.joaovitor.marvel.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by joaovitor on 31/08/17.
 */

public class RetroFitManager {
    private static RetroFitManager instance;
    private Retrofit retrofit;
    private Gson gson;


    private RetroFitManager(){
        setUp();
    }
    public static RetroFitManager getInstance(){
        if(instance == null){
            instance = new RetroFitManager();
        }
        return instance;
    }

    private void setUp(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        OkHttpClient client = okHttpBuilder
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        if(gson == null) {
            gson = new GsonBuilder()
                    .create();
        }
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BuildConfig.base_url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxAdapter);
                //.addCallAdapterFactory(RxThreadCallAdapter.create(io(), mainThread()));

        retrofit = builder.build();
    }

    public <T> T createService(Class<T> tClass) {
        return retrofit.create(tClass);
    }
}
