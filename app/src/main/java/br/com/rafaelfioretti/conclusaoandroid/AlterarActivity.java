package br.com.rafaelfioretti.conclusaoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rafaelfioretti.conclusaoandroid.dao.CondominioDAO;
import br.com.rafaelfioretti.conclusaoandroid.model.Condominio;

public class AlterarActivity extends AppCompatActivity {

    EditText etCond;
    EditText etEnd;
    EditText etSind;
    EditText etBloco;
    Condominio cond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);
        etCond = (EditText) findViewById(R.id.etCondominio);
        etEnd = (EditText) findViewById(R.id.etEndereco);
        etSind = (EditText) findViewById(R.id.etSindico);
        etBloco = (EditText) findViewById(R.id.etBlocos);
        carregaTela();

    }

    public void carregaTela(){
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        cond = (Condominio) bundle.getSerializable("cond");
        etCond.setText(cond.getNome().toString());
        etEnd.setText(cond.getEndereco().toString());
        etSind.setText(cond.getSindico().toString());
        etBloco.setText(String.valueOf(cond.getBlocos()));
    }


    public void update(View v){

        String mensagem = "";

        if (etCond.getText().toString().equals("")) {
            mensagem += getString(R.string.preencherCond);
        }
        if (etEnd.getText().toString().equals("")) {
            mensagem += getString(R.string.preencherEnd);
        }
        if (etBloco.getText().toString().equals("")) {
            mensagem += getString(R.string.preencherBloco);
        }
        if (etSind.getText().toString().equals("")) {
            mensagem += getString(R.string.preencherSind);
        }

        if (mensagem.equals("")) {
            salvarDados();
        } else {
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
        }
    }

    public void salvarDados(){
        CondominioDAO condDAO = new CondominioDAO();
        cond.setNome(etCond.getText().toString());
        cond.setEndereco(etEnd.getText().toString());
        cond.setBlocos(Integer.parseInt(etBloco.getText().toString()));
        cond.setSindico(etSind.getText().toString());

        condDAO.alteraRegistro(cond);

        Toast.makeText(this, R.string.atualizadoSucesso, Toast.LENGTH_SHORT).show();
        limpaCampos();

    }

    public void limpaCampos(){
        etCond.setText("");
        etEnd.setText("");
        etBloco.setText("");
        etSind.setText("");
        startActivity(new Intent(this, MainActivity.class));

    }

}
