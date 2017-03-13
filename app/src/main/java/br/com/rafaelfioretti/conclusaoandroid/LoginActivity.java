package br.com.rafaelfioretti.conclusaoandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.rafaelfioretti.conclusaoandroid.dao.UsuarioDAO;
import br.com.rafaelfioretti.conclusaoandroid.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    EditText etUser;
    EditText etSenha;
    CheckBox cbLogado;
    Usuario user = new Usuario();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cbLogado = (CheckBox) findViewById(R.id.cbConectado);
        checkConectado();

    }

    public void logar (View v){
        obterUsuario();

        etUser = (EditText) findViewById(R.id.etUsuario);
        etSenha = (EditText) findViewById(R.id.etPassword);


        if (user.getUsuario().equals(etUser.getText().toString()) && user.getSenha().equals(etSenha.getText().toString())){
            if (cbLogado.isChecked()){
                salvarPreferencia(user.getUsuario(), true);
            }
            abrirTela();
        }
        else{
            Toast.makeText(this, R.string.msglogin, Toast.LENGTH_LONG).show();
        }

    }

    public void obterUsuario(){
        UsuarioDAO usuariodao = new UsuarioDAO();
        user = usuariodao.carregaDado();
        Log.d(user.getUsuario(), user.getSenha());
    }

    private void checkConectado(){
        SharedPreferences settings = getSharedPreferences("PREFERENCIAS", MODE_PRIVATE);
        if (settings.getBoolean("manterConectado",false)){
            abrirTela();
        }
    }

    public void salvarPreferencia(String usuario, boolean isConectado){
        SharedPreferences settings = getSharedPreferences("PREFERENCIAS", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("usuario", usuario);
        editor.putBoolean("manterConectado", isConectado);
        editor.commit();

    }

    private void abrirTela(){
        startActivity(new Intent(this, MainActivity.class));
    }

}
