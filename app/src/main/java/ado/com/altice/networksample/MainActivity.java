package ado.com.altice.networksample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RemoteService remoteService = retrofit.create(RemoteService.class);

        remoteService.getUsers().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Response res = response.body();
                for(User user : res.users)
                    Log.d(TAG, user.lastName);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                t.printStackTrace();
            }
        });

        remoteService.register(new User("eve.holt@reqres.in", "pistol"))
                .enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, retrofit2.Response<Token> response) {
                Log.d(TAG, response.body().token);
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                t.printStackTrace();
            }
        });


        Glide.with(this)
                .load("https://via.placeholder.com/150")
                .into(((ImageView)findViewById(R.id.iv)));
    }
}
