package br.com.rafaelfioretti.conclusaoandroid.model;

/**
 * Created by rafaelfioretti on 12/12/16.
 */

public class Livro {

    public final static String NOME_TABELA = "livros";
    public final static String ID = "_id";
    public final static String TITULO = "titulo";
    public final static String AUTOR = "autor";
    public final static String EDITORA = "editora";

    private int id;
    private String titulo;
    private String autor;
    private String editora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
