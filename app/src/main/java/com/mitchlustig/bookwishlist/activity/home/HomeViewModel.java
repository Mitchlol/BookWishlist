package com.mitchlustig.bookwishlist.activity.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.mitchlustig.bookwishlist.service.Model.User;
import com.mitchlustig.bookwishlist.service.WishlistService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {
    
    
    private WishlistService service;
    private final MutableLiveData<List<User>> users = new MutableLiveData<>();
    private final ObservableBoolean loading = new ObservableBoolean(false);


    public void setService(WishlistService service){
        this.service = service;
        load();
    }
    
    public LiveData<List<User>> users() {
        return users;
    }

    public ObservableBoolean isLoading() {
        return loading;
    }

    private void load() {
        if(service != null){
            loading.set(true);
            service.users().enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    users.postValue(response.body());
                    loading.set(false);
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    loading.set(false);
                }
            });
        }
    }
}
