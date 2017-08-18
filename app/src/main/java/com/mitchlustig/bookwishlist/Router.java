package com.mitchlustig.bookwishlist;

import android.content.Context;

import com.mitchlustig.bookwishlist.activity.HomeActivity;
import com.mitchlustig.bookwishlist.activity.booklist.BooksActivity;

public class Router {
    public static void home(Context context){
        context.startActivity(HomeActivity.getIntent(context));
    }

    public static void allBooks(Context context){
        context.startActivity(BooksActivity.getIntent(context));
    }
}
