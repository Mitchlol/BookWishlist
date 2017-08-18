package com.mitchlustig.bookwishlist;

import android.content.Context;

import com.mitchlustig.bookwishlist.activity.book.BookActivity;
import com.mitchlustig.bookwishlist.activity.home.HomeActivity;
import com.mitchlustig.bookwishlist.activity.booklist.BooksActivity;
import com.mitchlustig.bookwishlist.activity.booklist.WishlistActivity;
import com.mitchlustig.bookwishlist.activity.user.AddUserActivity;

public class Router {
    public static void home(Context context){
        context.startActivity(HomeActivity.getIntent(context));
    }

    public static void allBooks(Context context){
        context.startActivity(BooksActivity.getIntent(context));
    }

    public static void book(Context context, int bookId){
        context.startActivity(BookActivity.getIntent(context, bookId));
    }

    public static void wishlist(Context context, int userId, String firstName){
        context.startActivity(WishlistActivity.getIntent(context, userId, firstName));
    }

    public static void addUser(Context context){
        context.startActivity(AddUserActivity.getIntent(context));
    }
}
