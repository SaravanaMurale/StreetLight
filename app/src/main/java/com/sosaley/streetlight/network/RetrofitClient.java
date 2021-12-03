package com.sosaley.streetlight.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sosaley.streetlight.utils.Util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    static Retrofit retrofit;
   static Gson gson=new GsonBuilder()
            .setLenient()
            .create();

    public static Retrofit getInstance(){

        retrofit=new Retrofit.Builder()
                .baseUrl(Util.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;

    }

    public static ApiInteface getApiClient(){

        ApiInteface apiInteface=RetrofitClient.getInstance().create(ApiInteface.class);

        return apiInteface;
    }

}
