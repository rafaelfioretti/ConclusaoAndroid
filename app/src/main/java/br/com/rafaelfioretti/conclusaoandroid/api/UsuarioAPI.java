package br.com.rafaelfioretti.conclusaoandroid.api;

import java.util.List;

import br.com.rafaelfioretti.conclusaoandroid.model.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rafaelfioretti on 11/19/16.
 */

public interface UsuarioAPI {


    @GET("/v2/{user}")
    Call<Usuario> getUser(@Path("user") String user);

}
