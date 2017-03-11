package br.com.rafaelfioretti.conclusaoandroid.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.com.rafaelfioretti.conclusaoandroid.MinhaAplicacao;

/**
 * Created by rafaelfioretti on 12/12/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static String NOME_BANCO = "conclusao.db";
    public static int VERSAO_BANCO = 1;

    public DBHelper(){
        super(MinhaAplicacao.getContext(), NOME_BANCO, null, VERSAO_BANCO );
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioDAO.createTable());
        db.execSQL(CondominioDAO.createTable());
       // seed();
        Log.d("tabelas criadas", "sqllite");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
