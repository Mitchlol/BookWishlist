package com.mitchlustig.bookwishlist;

import android.content.Context;

import com.mitchlustig.bookwishlist.activity.BookActivity;
import com.mitchlustig.bookwishlist.activity.HomeActivity;
import com.mitchlustig.bookwishlist.activity.booklist.BooksActivity;
import com.mitchlustig.bookwishlist.activity.booklist.WishlistActivity;

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

    public static void wishlist(Context context, int userId){
        context.startActivity(WishlistActivity.getIntent(context, userId));
    }
}
