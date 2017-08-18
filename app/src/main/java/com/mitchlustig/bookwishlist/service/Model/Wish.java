package com.mitchlustig.bookwishlist.service.Model;
import com.google.gson.annotations.SerializedName;

public class Wish {
    @SerializedName("book_id")
    private int bookId;

    @SerializedName("user_id")
    private int userId;

    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "bookId=" + bookId +
                ", userId=" + userId +
                '}';
    }
}
