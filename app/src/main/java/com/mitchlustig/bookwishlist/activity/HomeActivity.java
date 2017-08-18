package com.mitchlustig.bookwishlist.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mitchlustig.bookwishlist.BR;
import com.mitchlustig.bookwishlist.R;
import com.mitchlustig.bookwishlist.Router;
import com.mitchlustig.bookwishlist.service.Model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.recycler) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getService().users().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                recyclerView.setAdapter(new UserListAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    public void viewAllBooks(View v) {
        Router.allBooks(this);
    }

    private class UserListAdapter extends RecyclerView.Adapter <UserListAdapter.UserListItemHolder> {
        List<User> users;
        public UserListAdapter(List<User> users){
            this.users = users;
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
