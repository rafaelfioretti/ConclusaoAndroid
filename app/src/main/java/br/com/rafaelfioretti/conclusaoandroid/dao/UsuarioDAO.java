package br.com.rafaelfioretti.conclusaoandroid.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.rafaelfioretti.conclusaoandroid.model.Usuario;

/**
 * Created by rafaelfioretti on 12/12/16.
 */

public class UsuarioDAO {

    private SQLiteDatabase db;

    public static String createTable() {
        return "CREATE TABLE " + Usuario.NOME_TABELA + " ( "
                + Usuario.USUARIO + " text primary key, "
                + Usuario.SENHA + " text) ";
    }

    public String insereDado(Usuario usuario) {

        ContentValues valores;
        long resultado;

        db = DatabaseManager.getInstance().openDatabase(false);
        valores = new ContentValues();
        valores.put(Usuario.USUARIO, usuario.getUsuario());
        valores.put(Usuario.SENHA, usuario.getSenha());
        resultado = db.insert(Usuario.NOME_TABELA, null, valores);

        DatabaseManager.getInstance().closeDatabase();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Usuario carregaDado() {
        Cursor cursor;
        Usuario user = new Usuario();
        String[] campos = {Usuario.USUARIO, Usuario.SENHA};
        db = DatabaseManager.getInstance().openDatabase(true);
        cursor = db.query(Usuario.NOME_TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                user.setUsuario(cursor.getString(cursor.getColumnIndex(user.USUARIO)));
                user.setSenha(cursor.getString(cursor.getColumnIndex(user.SENHA)));
            }
        }
        DatabaseManager.getInstance().closeDatabase();

        return user;
    }

}