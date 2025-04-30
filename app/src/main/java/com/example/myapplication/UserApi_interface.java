package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi_interface {
    @GET("/users")
    Call<User_data> get_User_data();
}
