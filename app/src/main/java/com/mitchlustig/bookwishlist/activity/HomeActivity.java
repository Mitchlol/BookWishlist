package com.mitchlustig.bookwishlist.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mitchlustig.bookwishlist.BR;
import com.mitchlustig.bookwishlist.R;
import com.mitchlustig.bookwishlist.databinding.ActivityHomeBinding;
import com.mitchlustig.bookwishlist.service.Model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    HomeViewModel viewModel;

    @BindView(R.id.recycler) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.setViewmodel(viewModel);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserListAdapter());
        viewModel.users().observe(this, users -> {
            ((UserListAdapter)recyclerView.getAdapter()).update(users);
        });

        viewModel.setService(getService());
    }

    private class UserListAdapter extends RecyclerView.Adapter <UserListAdapter.UserListItemHolder> {
        List<User> users;

        public UserListAdapter(){
            this.users = new ArrayList<>();
        }

        public void update(List<User> users){
            this.users = users;
            notifyDataSetChanged();
        }
        class UserListItemHolder extends RecyclerView.ViewHolder {

            // each data item is just a string in this case
            private final ViewDataBinding binding;

            public UserListItemHolder(ViewDataBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
            public void bind(User user) {
                binding.setVariable(BR.user, user);
                binding.executePendingBindings();
            }
        }
        @Override
        public UserListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.user_list_item, parent, false);
            return new UserListItemHolder(binding);
        }

        @Override
        public void onBindViewHolder(UserListItemHolder holder, int position) {
            holder.bind(users.get(position));
        }

        @Override
        public int getItemCount() {
            return users.size();
        }
    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }
}
