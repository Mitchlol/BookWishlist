package com.mitchlustig.bookwishlist.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.mitchlustig.bookwishlist.R;
import com.mitchlustig.bookwishlist.Router;
import com.mitchlustig.bookwishlist.databinding.ActivityBookBinding;
import com.mitchlustig.bookwishlist.service.Model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookActivity extends BaseActivity {

    private static final String EXTRA_BOOK_ID = "EXTRA_BOOK_ID";

    private ActivityBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book);

        getService().books().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                int bookId = getIntent().getIntExtra(EXTRA_BOOK_ID, -1);
                for(Book book: response.body()){
                    if(book.getId() == bookId){
                        binding.setBook(book);
                        break;
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }

    public void home(View v) {
        Router.home(this);
    }

    public static Intent getIntent(Context context, int bookId){
        Intent intent = new Intent(context, BookActivity.class);
        intent.putExtra(EXTRA_BOOK_ID, bookId);
        return intent;
    }

}
