package com.mitchlustig.bookwishlist.activity.booklist;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mitchlustig.bookwishlist.R;
import com.mitchlustig.bookwishlist.Router;
import com.mitchlustig.bookwishlist.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WishlistActivity extends BaseActivity {

    private static final String EXTRA_USER_ID = "EXTRA_USER_ID";

    @BindView(R.id.recycler) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);
        ButterKnife.bind(this);

        WishlistViewModel viewModel = ViewModelProviders.of(this).get(WishlistViewModel.class);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.books().observe(this, books -> {
            recyclerView.setAdapter(new BookListAdapter(books));
        });

        viewModel.init(getService(), getIntent().getIntExtra(EXTRA_USER_ID, -1));
    }

    public void home(View v) {
        Router.home(this);
    }

    public static Intent getIntent(Context context, int userId){
        Intent intent = new Intent(context, WishlistActivity.class);
        intent.putExtra(EXTRA_USER_ID, userId);
        return intent;
    }
}
