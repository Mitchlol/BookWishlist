package com.mitchlustig.bookwishlist.activity.booklist;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mitchlustig.bookwishlist.BR;
import com.mitchlustig.bookwishlist.R;
import com.mitchlustig.bookwishlist.service.Model.Book;

import java.util.List;

/**
 * Created by Mitch on 8/16/2017.
 */
class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookListItemHolder> {
    List<Book> books;

    public BookListAdapter(List<Book> books) {
        this.books = books;
    }

    class BookListItemHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        private final ViewDataBinding binding;

        public BookListItemHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Book book) {
            binding.setVariable(BR.book, book);
            binding.executePendingBindings();
        }
    }

    @Override
    public BookListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.book_list_item, parent, false);
        return new BookListItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(BookListItemHolder holder, int position) {
        holder.bind(books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
