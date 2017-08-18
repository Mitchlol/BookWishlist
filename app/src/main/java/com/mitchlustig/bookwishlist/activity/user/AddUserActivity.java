package com.mitchlustig.bookwishlist.activity.user;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.mitchlustig.bookwishlist.R;
import com.mitchlustig.bookwishlist.activity.BaseActivity;
import com.mitchlustig.bookwishlist.activity.booklist.WishlistViewModel;
import com.mitchlustig.bookwishlist.databinding.ActivityAdduserBinding;
import com.mitchlustig.bookwishlist.service.Model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AddUserViewModel viewModel = ViewModelProviders.of(this).get(AddUserViewModel.class);
        ActivityAdduserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_adduser);
        binding.setViewmodel(viewModel);

    }
    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, AddUserActivity.class);
        return intent;
    }
}
