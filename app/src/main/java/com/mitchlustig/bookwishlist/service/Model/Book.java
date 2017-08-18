package com.mitchlustig.bookwishlist.service.Model;

import com.google.gson.annotations.SerializedName;

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
