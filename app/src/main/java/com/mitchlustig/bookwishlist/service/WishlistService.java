package com.mitchlustig.bookwishlist.service;

import com.mitchlustig.bookwishlist.service.Model.Book;
import com.mitchlustig.bookwishlist.service.Model.User;
import com.mitchlustig.bookwishlist.service.Model.Wish;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface WishlistService {
    @GET("users")
    Call<List<User>> users();

    @GET("books")
    Call<List<Book>> books();

    @GET("wishlist")
    Call<List<Wish>> wishes();

    @POST("users/create")
    Call<User> addUser(@Body User user);
}
