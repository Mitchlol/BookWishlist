package com.mitchlustig.bookwishlist.activity.booklist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.mitchlustig.bookwishlist.service.Model.Book;
import com.mitchlustig.bookwishlist.service.WishlistService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksViewModel extends ViewModel {
    
    
    private WishlistService service;
    private final MutableLiveData<List<Book>> books = new MutableLiveData<>();
    private final ObservableBoolean loading = new ObservableBoolean(false);


    public void init(WishlistService service){
        this.service = service;
        load();
    }
    
    public LiveData<List<Book>> books() {
        return books;
    }

    public ObservableBoolean isLoading() {
        return loading;
    }

    private void load() {
        if(service != null){
            loading.set(true);
            service.books().enqueue(new Callback<List<Book>>() {
                @Override
                public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                    books.postValue(response.body());
                }

                @Override
                public void onFailure(Call<List<Book>> call, Throwable t) {
                    loading.set(true);
                }
            });
        }
    }
}
