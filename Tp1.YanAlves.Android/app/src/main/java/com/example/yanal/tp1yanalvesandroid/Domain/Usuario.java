package com.example.yanal.tp1yanalvesandroid.Domain;

import java.io.Serializable;

/**
 * Created by yanal on 02/10/2017.
 */

public class Usuario implements Serializable {

    private String Nome;
    private String Email;
    private String Telefone;
    private String Cidade;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }
}