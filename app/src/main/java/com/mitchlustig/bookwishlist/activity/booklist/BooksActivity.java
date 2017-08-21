package com.mitchlustig.bookwishlist.activity.booklist;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mitchlustig.bookwishlist.R;
import com.mitchlustig.bookwishlist.activity.BaseActivity;
import com.mitchlustig.bookwishlist.databinding.ActivityBooklistBinding;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BooksActivity extends BaseActivity {

    @BindView(R.id.recycler) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBooklistBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_booklist);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BooksViewModel viewModel = ViewModelProviders.of(this).get(BooksViewModel.class);
        viewModel.books().observe(this, books -> {
            recyclerView.setAdapter(new BookListAdapter(books));
        });

        viewModel.init(getService());
    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, BooksActivity.class);
        return intent;
    }
}
