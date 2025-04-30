package com.example.myapplication;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//10.0.2.2
public class Retrofit_instance {
    private static final String BASE_URL = "http://127.0.0.1:8000";
    //private static final String BASE_URL = "http://172.20.160.1:8000";
    //private static final String BASE_URL = "http://10.0.2.2:8000";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
