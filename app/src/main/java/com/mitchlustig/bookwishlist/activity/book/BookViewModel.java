package com.mitchlustig.bookwishlist.activity.book;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.text.Html;
import android.text.Spanned;

import com.mitchlustig.bookwishlist.service.Model.Book;
import com.mitchlustig.bookwishlist.service.WishlistService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookViewModel extends ViewModel {
    
    
    private WishlistService service;
    private int bookId;
    private final ObservableField<Spanned> title = new ObservableField();
    private final ObservableField<Spanned> author = new ObservableField();
    private final ObservableField<Spanned> isbn = new ObservableField();
    private final ObservableField<Spanned> date = new ObservableField();
    private final ObservableField<Spanned> summary = new ObservableField();
    private final ObservableBoolean loading = new ObservableBoolean(false);


    public void init(WishlistService service, int bookId){
        this.service = service;
        this.bookId = bookId;
        load();
    }

    public ObservableBoolean isLoading() {
        return loading;
    }

    public ObservableField<Spanned> getTitle() {
        return title;
    }

    public ObservableField<Spanned> getAuthor() {
        return author;
    }

    public ObservableField<Spanned> getIsbn() {
        return isbn;
    }

    public ObservableField<Spanned> getDate() {
        return date;
    }

    public ObservableField<Spanned> getSummary() {
        return summary;
    }

    private void load() {
        if(service != null){
            loading.set(true);
            service.books().enqueue(new Callback<List<Book>>() {
                @Override
                public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                    for(Book book: response.body()){
                        if(book.getId() == bookId){
                            title.set(Html.fromHtml("<b>Title: </b>" + book.getTitle(), 0));
                            author.set(Html.fromHtml("<b>Author: </b>" + book.getAuthor(), 0));
                            isbn.set(Html.fromHtml("<b>ISBN: </b>" + book.getIsbn(), 0));
                            date.set(Html.fromHtml("<b>Date of Publication: </b>" + book.getPublicationDate(), 0));
                            summary.set(Html.fromHtml("<b>Summary: </b>" + book.getSummary(), 0));
                            break;
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Book>> call, Throwable t) {

                }
            });
        }
    }
}
