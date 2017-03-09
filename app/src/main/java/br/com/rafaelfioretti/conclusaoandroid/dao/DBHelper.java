package br.com.rafaelfioretti.conclusaoandroid.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.rafaelfioretti.conclusaoandroid.MinhaAplicacao;
import br.com.rafaelfioretti.conclusaoandroid.model.Livro;

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
       // seed();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    /*
    private void seed(){
        UsuarioDAO livrodao = new UsuarioDAO();

        Livro android = new Livro();
        android.setAutor("Ricardo Lechetta");
        android.setEditora("Novatec");
        android.setTitulo("Google Android");
        livrodao.insereDado(android);

        Livro torreNegra = new Livro();
        android.setAutor("Stephen King");
        android.setEditora("AchoSuma");
        android.setTitulo("A Torre Negra");
        livrodao.insereDado(torreNegra);


    }
    */

}
