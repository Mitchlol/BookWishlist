package com.mitchlustig.bookwishlist;

import android.app.Application;

import com.mitchlustig.bookwishlist.service.WishlistService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BWApp extends Application {

    private WishlistService service;

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-54-218-40-37.us-west-2.compute.amazonaws.com:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(WishlistService.class);
    }

    public WishlistService getService() {
        return service;
    }
}
