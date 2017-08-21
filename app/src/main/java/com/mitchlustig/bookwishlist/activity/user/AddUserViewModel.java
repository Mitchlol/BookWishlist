package com.mitchlustig.bookwishlist.activity.user;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.mitchlustig.bookwishlist.service.Model.User;
import com.mitchlustig.bookwishlist.service.WishlistService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserViewModel extends ViewModel {
    
    
    private WishlistService service;
    private final ObservableField<String> firstName = new ObservableField();
    private final ObservableField<String> lastName = new ObservableField();
    private final ObservableField<String> email = new ObservableField();
    private final ObservableBoolean loading = new ObservableBoolean(false);


    public void setService(WishlistService service){
        this.service = service;
    }

    public ObservableBoolean isLoading() {
        return loading;
    }

    public ObservableField<String> getFirstName() {
        return firstName;
    }

    public ObservableField<String> getLastName() {
        return lastName;
    }

    public ObservableField<String> getEmail() {
        return email;
    }

    public void submit() {
        if(service != null && firstName.get() != null && lastName.get() != null && email.get() != null){
            loading.set(true);
            service.addUser(new User(firstName.get(), lastName.get(), email.get())).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User newUser = response.body();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
        }
    }
}
