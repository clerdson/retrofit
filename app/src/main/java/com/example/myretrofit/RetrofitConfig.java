package com.example.myretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitConfig {
private final Retrofit retrofit;
public RetrofitConfig(){

   this.retrofit =  new Retrofit.Builder().baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
public UsuarioService getUsuarioService(){

    return this.retrofit.create(UsuarioService.class);
}
}


