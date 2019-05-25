package ado.com.altice.networksample;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RemoteService {
    @GET("users/")
    Call<Response> getUsers();

    @POST("register/")
    Call<Token> register(@Body User user);
}
