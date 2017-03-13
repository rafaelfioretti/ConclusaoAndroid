package br.com.rafaelfioretti.conclusaoandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.com.rafaelfioretti.conclusaoandroid.Adapter.CondominioListAdapter;
import br.com.rafaelfioretti.conclusaoandroid.dao.CondominioDAO;
import br.com.rafaelfioretti.conclusaoandroid.listener.OnClickListener;
import br.com.rafaelfioretti.conclusaoandroid.model.Condominio;

public class ListarActivity extends AppCompatActivity {

    private RecyclerView rvCondominio;
    private CondominioListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int posicao;
    private int acao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        rvCondominio = (RecyclerView) findViewById(R.id.rv_condominio);
        rvCondominio.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        rvCondominio.setLayoutManager(mLayoutManager);
        CondominioDAO condominioDAO = new CondominioDAO();
        mAdapter = new CondominioListAdapter(this, condominioDAO.carregaDados(), onClickListener());
        rvCondominio.setAdapter(mAdapter);
    }

    public void editar(View v){


    }

    private OnClickListener onClickListener(){

        return new OnClickListener(){
            @Override
            public void onClick(View v, int position, int acao){
                posicao = position;
                if (acao == 2)
                {
                    excluir(v);
                }else
                {
                    editar();
                }
            }



        };}

    public void excluir(final View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(R.string.msgexcluir);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        CondominioDAO condDAO = new CondominioDAO();
                        condDAO.deletaRegistro(mAdapter.getItem(posicao).getId());
                        mAdapter.removeAt(posicao);
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                R.string.no,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }

    public void editar(){
        Bundle bundle = new Bundle();
        bundle.putSerializable("cond", mAdapter.getItem(posicao));
        Intent i = new Intent(this, AlterarActivity.class);
        i.putExtras(bundle);
        startActivity(i);
    }
}
