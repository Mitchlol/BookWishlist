package com.mitchlustig.bookwishlist.service.Model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private int id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("email")
    private String email;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() { return firstName + " " + lastName;}

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "BookListItemHolder{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
