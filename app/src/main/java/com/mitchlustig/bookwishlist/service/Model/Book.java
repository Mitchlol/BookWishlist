package com.mitchlustig.bookwishlist.service.Model;

import android.content.Intent;
import android.view.View;

import com.google.gson.annotations.SerializedName;
import com.mitchlustig.bookwishlist.activity.BookActivity;

public class Book {
    @SerializedName("id")
    private int id;

    @SerializedName("author")
    private String author;

    @SerializedName("isbn")
    private int isbn;

    @SerializedName("publication_date")
    private String publicationDate;

    @SerializedName("title")
    private String title;

    @SerializedName("summary")
    private String summary;

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public void showBookDetails(View v){
        Intent intent = new Intent(v.getContext(), BookActivity.class);
        v.getContext().startActivity(intent);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", isbn=" + isbn +
                ", publicationDate='" + publicationDate + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
