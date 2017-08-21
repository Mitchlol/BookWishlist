package com.mitchlustig.bookwishlist.activity.user;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.mitchlustig.bookwishlist.R;
import com.mitchlustig.bookwishlist.activity.BaseActivity;
import com.mitchlustig.bookwishlist.databinding.ActivityAdduserBinding;

public class AddUserActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AddUserViewModel viewModel = ViewModelProviders.of(this).get(AddUserViewModel.class);
        viewModel.setService(getService());
        ActivityAdduserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_adduser);
        binding.setViewmodel(viewModel);

    }
    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, AddUserActivity.class);
        return intent;
    }
}
