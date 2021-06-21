package com.example.put_patch_delete.API;

import com.example.put_patch_delete.Model.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    // LINK : https://jsonplaceholder.typicode.com/posts
    public static final String DOMAIM = "https://jsonplaceholder.typicode.com/";
    Gson gson = new GsonBuilder().setDateFormat("yyyy MM dd HH:mm:ss").create();
    JsonPlaceHolderApi apiService = new Retrofit.Builder()
            .baseUrl(DOMAIM)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(JsonPlaceHolderApi.class);
    @GET("posts")
    Call<ArrayList<Post>> getPosts();



    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id , @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id , @Body Post post);


    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);

}
