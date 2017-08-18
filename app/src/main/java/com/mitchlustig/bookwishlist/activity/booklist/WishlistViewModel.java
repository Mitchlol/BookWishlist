package com.mitchlustig.bookwishlist.activity.booklist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.mitchlustig.bookwishlist.service.Model.Book;
import com.mitchlustig.bookwishlist.service.Model.Wish;
import com.mitchlustig.bookwishlist.service.WishlistService;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WishlistViewModel extends ViewModel {
    
    
    private WishlistService service;
    private int userId;
    private List<Wish> wishes;
    private List<Book> allBooks;
    private final MutableLiveData<List<Book>> books = new MutableLiveData<>();
    private final ObservableBoolean loading = new ObservableBoolean(false);


    public void init(WishlistService service, int userId){
        this.service = service;
        this.userId = userId;
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
            service.wishes().enqueue(new Callback<List<Wish>>() {
                @Override
                public void onResponse(Call<List<Wish>> call, Response<List<Wish>> response) {
                    wishes = response.body();
                    //nest call? gross
                    service.books().enqueue(new Callback<List<Book>>() {
                        @Override
                        public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                            allBooks = response.body();
                            //O(NxM) on ui thread? lol
                            List<Integer> usersWishes = wishes.stream().filter(item -> item.getUserId() == userId).map(item -> item.getBookId()).collect(Collectors.toList());
                            books.postValue(allBooks.stream().filter(item -> usersWishes.contains(item.getId())).collect(Collectors.toList()));
                        }

                        @Override
                        public void onFailure(Call<List<Book>> call, Throwable t) {
                            loading.set(true);
                        }
                    });
                }

                @Override
                public void onFailure(Call<List<Wish>> call, Throwable t) {
                    loading.set(true);
                }
            });
        }
    }
}
