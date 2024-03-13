package com.example.retrofit_ex;

import java.lang.annotation.Target;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getcountrydata {
//Retrofit interface
    @GET("countries")
    Call<Result> getResult();
}
