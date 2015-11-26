package com.example.andrea.listautenti;

/**
 * Created by andrea on 25.11.15.
 */
public class User {

    /* Variabili di istanza */
    private int id;
    private String nome;
    private String indirizzo;


    /* Costruttori */
    User (int id, String nome, String indirizzo) {
    /* inizializzazione, this è riferito alla classe */
            this.id = id;
            this.nome = nome;
            this.indirizzo = indirizzo;
        }

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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
