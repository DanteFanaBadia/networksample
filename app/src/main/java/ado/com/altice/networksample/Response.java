package ado.com.altice.networksample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    @SerializedName("page")
    Integer page;
    @SerializedName("per_page")
    Integer perPage;
    @SerializedName("total")
    Integer total;
    @SerializedName("total_pages")
    Integer totalPages;
    @SerializedName("data")
    List<User> users;
}
