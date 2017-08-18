package com.mitchlustig.bookwishlist.activity;

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
    ActivityBookBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book);

        getService().books().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                binding.setBook(response.body().get(0));
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }

    public void home(View v) {
        Router.home(this);
    }

}
