package com.mitchlustig.bookwishlist.activity.booklist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mitchlustig.bookwishlist.R;
import com.mitchlustig.bookwishlist.Router;
import com.mitchlustig.bookwishlist.activity.BaseActivity;
import com.mitchlustig.bookwishlist.service.Model.Book;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksActivity extends BaseActivity {

    @BindView(R.id.recycler) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getService().books().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                recyclerView.setAdapter(new BookListAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }

    public void home(View v) {
        Router.home(this);
    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, BooksActivity.class);
        return intent;
    }
}
