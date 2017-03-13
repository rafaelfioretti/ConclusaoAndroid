package br.com.rafaelfioretti.conclusaoandroid.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelfioretti.conclusaoandroid.model.Condominio;

/**
 * Created by rafaelfioretti on 12/12/16.
 */

public class CondominioDAO {
    
    private SQLiteDatabase db;

    public static String createTable() {
        Log.d("tabelas cond", "sqllite");

        return "CREATE TABLE " + Condominio.NOME_TABELA + " ( "
                + Condominio.ID + " integer primary key autoincrement, "
                + Condominio.NOME + " text, "
                + Condominio.ENDERECO + " text, "
                + Condominio.BLOCOS + " integer, "
                + Condominio.SINDICO + " text )";

    }

    public String insereDado(Condominio cond) {

        ContentValues valores;
        long resultado;

        db = DatabaseManager.getInstance().openDatabase(false);
        valores = new ContentValues();
        valores.put(Condominio.NOME, cond.getNome());
        valores.put(Condominio.ENDERECO, cond.getEndereco());
        valores.put(Condominio.BLOCOS, cond.getBlocos());
        valores.put(Condominio.SINDICO, cond.getSindico());
        resultado = db.insert(Condominio.NOME_TABELA, null, valores);

        DatabaseManager.getInstance().closeDatabase();

        if (resultado == -1)
            return "Erro ao inserir Condomínio";
        else
            return "Registro Inserido com sucesso";
    }

    public List<Condominio> carregaDados() {
        List<Condominio> condominios = new ArrayList<>();

        Cursor cursor;
        String[] campos = {Condominio.ID, Condominio.NOME, Condominio.ENDERECO, Condominio.BLOCOS, Condominio.SINDICO};
        db = DatabaseManager.getInstance().openDatabase(true);
        //cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);
        cursor = db.query(Condominio.NOME_TABELA, null, null, null, null, null, null, null);

        if (cursor != null) {
            if(cursor.moveToFirst()){
                do {
                    Condominio cond = new Condominio();
                    cond.setId(cursor.getInt(cursor.getColumnIndex(cond.ID)));
                    cond.setNome(cursor.getString(cursor.getColumnIndex(Condominio.NOME)));
                    cond.setEndereco(cursor.getString(cursor.getColumnIndex(Condominio.ENDERECO)));
                    cond.setBlocos(cursor.getInt(cursor.getColumnIndex(Condominio.BLOCOS)));
                    cond.setSindico(cursor.getString(cursor.getColumnIndex(Condominio.SINDICO)));
                    condominios.add(cond);
                } while(cursor.moveToNext());
            }
        }
        DatabaseManager.getInstance().closeDatabase();
        return condominios;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {Condominio.ID,Condominio.NOME, Condominio.ENDERECO, Condominio.BLOCOS, Condominio.SINDICO};
        String where = Condominio.ID + "=" + id;
        db = DatabaseManager.getInstance().openDatabase(true);
        cursor = db.query(Condominio.NOME_TABELA, campos, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        DatabaseManager.getInstance().closeDatabase();
        return cursor;
    }

    public void alteraRegistro(Condominio cond){
        ContentValues valores;
        String where;

        db = DatabaseManager.getInstance().openDatabase(false);

        where = Condominio.ID + "=" + cond.getId();

        valores = new ContentValues();
        valores.put(Condominio.ID, cond.getId());
        valores.put(Condominio.NOME, cond.getNome());
        valores.put(Condominio.ENDERECO, cond.getEndereco());
        valores.put(Condominio.BLOCOS, cond.getBlocos());
        valores.put(Condominio.SINDICO, cond.getSindico());


        db.update(Condominio.NOME_TABELA, valores,where,null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public void deletaRegistro(int id){
        String where = Condominio.ID + "=" + id;
        db = DatabaseManager.getInstance().openDatabase(false);
        db.delete(Condominio.NOME_TABELA,where,null);
        DatabaseManager.getInstance().closeDatabase();
     }
    
    
}
