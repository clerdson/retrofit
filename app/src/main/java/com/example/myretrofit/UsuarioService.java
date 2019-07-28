package com.example.myretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsuarioService {
    @GET("/users/{usuario}")
    Call<Usuario> BuscarUsers(@Path("usuario") String usuario);
}
