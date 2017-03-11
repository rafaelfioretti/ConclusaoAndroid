package br.com.rafaelfioretti.conclusaoandroid;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import br.com.rafaelfioretti.conclusaoandroid.dao.DBHelper;
import br.com.rafaelfioretti.conclusaoandroid.dao.DatabaseManager;
import br.com.rafaelfioretti.conclusaoandroid.dao.UsuarioDAO;
import br.com.rafaelfioretti.conclusaoandroid.model.Usuario;

/**
 * Created by rafaelfioretti on 12/12/16.
 */

public class MinhaAplicacao extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        this.context = getApplicationContext();
        DatabaseManager.initializeInstance(new DBHelper());
    }

    public static Context getContext(){
        return context;

    }
}
