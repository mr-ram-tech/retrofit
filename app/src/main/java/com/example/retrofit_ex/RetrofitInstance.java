package com.example.retrofit_ex;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

 private static Retrofit retrofit = null;

 private static String base_url = "https://api.printful.com/";

 //Single pattern used to create an instant retrofit

public static getcountrydata getService(){
    if(retrofit == null){
        retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    return retrofit.create(getcountrydata.class);
}

}
