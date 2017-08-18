package com.mitchlustig.bookwishlist.service;

import com.mitchlustig.bookwishlist.service.Model.Book;
import com.mitchlustig.bookwishlist.service.Model.User;
import com.mitchlustig.bookwishlist.service.Model.Wish;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WishlistService {
    @GET("users")
    Call<List<User>> users();

    @GET("books")
    Call<List<Book>> books();

    @GET("wishlist")
    Call<List<Wish>> wishes();
}
