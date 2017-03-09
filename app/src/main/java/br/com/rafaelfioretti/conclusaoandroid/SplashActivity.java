package br.com.rafaelfioretti.conclusaoandroid;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import br.com.rafaelfioretti.conclusaoandroid.api.UsuarioAPI;
import br.com.rafaelfioretti.conclusaoandroid.model.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static br.com.rafaelfioretti.conclusaoandroid.MinhaAplicacao.getContext;

public class SplashActivity extends AppCompatActivity implements Callback<List<Usuario>> {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        carregar();
        loadUsuario();
    }

    private void carregar() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.animacao);
        anim.reset();

        //Pegando o nosso objeto criado no layout
        ImageView iv = (ImageView) findViewById(R.id.splash_logo);
        if (iv != null) {
            iv.clearAnimation();
            iv.startAnimation(anim);
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Após o tempo definido irá executar a próxima tela
                Intent intent = new Intent(SplashActivity.this,
                        LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    private void loadUsuario() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioAPI api = retrofit.create(UsuarioAPI.class);
        Call<List<Usuario>> call = api.getUser("58b9b1740f0000b614f09d2f");
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
        System.out.print(response);
        Toast.makeText(getContext(), response.toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFailure(Call<List<Usuario>> call, Throwable t) {
        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

    }
}
