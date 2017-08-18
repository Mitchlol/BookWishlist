package com.mitchlustig.bookwishlist.activity;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mitchlustig.bookwishlist.BWApp;
import com.mitchlustig.bookwishlist.service.WishlistService;

public class BaseActivity extends LifecycleActivity {
    private WishlistService service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = ((BWApp)getApplication()).getService();
    }

    public WishlistService getService() {
        return service;
    }
}
