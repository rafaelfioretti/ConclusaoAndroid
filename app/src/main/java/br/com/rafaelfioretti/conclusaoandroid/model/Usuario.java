package br.com.rafaelfioretti.conclusaoandroid.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;


/**
 * Created by rafaelfioretti on 12/12/16.
 */

public class Usuario implements Parcelable{

    public final static String NOME_TABELA = "login";
    //public final static String ID = "_id";
    public final static String USUARIO = "usuario";
    public final static String SENHA = "senha";

    //private int id;
    //@SerializedName("usuario") //notação sempre em cima da variavel em questão
    private String usuario;
    //@SerializedName("senha") //notação sempre em cima da variavel em questão
    private String senha;

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario() {
    }

    protected Usuario(Parcel in) {
        usuario = in.readString();
        senha = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(usuario);
        parcel.writeString(senha);


    }
}
