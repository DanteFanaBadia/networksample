package ado.com.altice.networksample;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    Integer id;
    @SerializedName("email")
    String email;
    @SerializedName("first_name")
    String firstName;
    @SerializedName("password")
    String password;
    @SerializedName("last_name")
    String lastName;
    @SerializedName("avatar")
    String avatar;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }
}
