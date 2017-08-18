package com.mitchlustig.bookwishlist.activity.book;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.mitchlustig.bookwishlist.R;
import com.mitchlustig.bookwishlist.activity.BaseActivity;
import com.mitchlustig.bookwishlist.databinding.ActivityBookBinding;

public class BookActivity extends BaseActivity {

    private static final String EXTRA_BOOK_ID = "EXTRA_BOOK_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBookBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_book);

        BookViewModel viewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        binding.setViewmodel(viewModel);

        viewModel.init(getService(), getIntent().getIntExtra(EXTRA_BOOK_ID, -1));
    }

    public static Intent getIntent(Context context, int bookId){
        Intent intent = new Intent(context, BookActivity.class);
        intent.putExtra(EXTRA_BOOK_ID, bookId);
        return intent;
    }

}
