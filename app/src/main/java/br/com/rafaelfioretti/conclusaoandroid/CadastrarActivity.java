package br.com.rafaelfioretti.conclusaoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rafaelfioretti.conclusaoandroid.dao.CondominioDAO;
import br.com.rafaelfioretti.conclusaoandroid.model.Condominio;

public class CadastrarActivity extends AppCompatActivity {

    EditText etNome;
    EditText etEndereco;
    EditText etBlocos;
    EditText etSindico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
    }

    public void cadastrar(View v) {
        etNome = (EditText) findViewById(R.id.etCondominio);
        etEndereco = (EditText) findViewById(R.id.etEndereco);
        etBlocos = (EditText) findViewById(R.id.etBlocos);
        etSindico = (EditText) findViewById(R.id.etSindico);
        String mensagem = "";

        if (etNome.getText().toString().equals("")) {
            mensagem += getString(R.string.preencherCond);
        }
        if (etEndereco.getText().toString().equals("")) {
            mensagem += getString(R.string.preencherEnd);
        }
        if (etBlocos.getText().toString().equals("")) {
            mensagem += getString(R.string.preencherBloco);
        }
        if (etSindico.getText().toString().equals("")) {
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
        Condominio cond = new Condominio();
        cond.setNome(etNome.getText().toString());
        cond.setEndereco(etEndereco.getText().toString());
        cond.setBlocos(Integer.parseInt(etBlocos.getText().toString()));
        cond.setSindico(etSindico.getText().toString());

        condDAO.insereDado(cond);

        Toast.makeText(this, R.string.cadastrosucesso, Toast.LENGTH_SHORT).show();
        limpaCampos();

    }

    public void limpaCampos(){
        etNome.setText("");
        etEndereco.setText("");
        etBlocos.setText("");
        etSindico.setText("");
    }
}
