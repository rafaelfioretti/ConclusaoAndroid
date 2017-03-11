package br.com.rafaelfioretti.conclusaoandroid.model;

/**
 * Created by rafaelfioretti on 3/11/17.
 */

public class Condominio {

        public final static String NOME_TABELA = "condominio";
        public final static String ID = "_id";
        public final static String NOME = "nome";
        public final static String ENDERECO = "endereco";
        public final static String BLOCOS = "blocos";
        public final static String SINDICO = "sindico";


        private int id;
        private String nome;
        private String endereco;
        private int blocos;
        private String sindico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getBlocos() {
        return blocos;
    }

    public void setBlocos(int blocos) {
        this.blocos = blocos;
    }

    public String getSindico() {
        return sindico;
    }

    public void setSindico(String sindico) {
        this.sindico = sindico;
    }
}
