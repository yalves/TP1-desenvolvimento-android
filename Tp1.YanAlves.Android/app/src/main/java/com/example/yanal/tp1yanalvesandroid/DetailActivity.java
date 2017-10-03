package com.example.yanal.tp1yanalvesandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.yanal.tp1yanalvesandroid.Domain.Usuario;

import java.io.Serializable;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();

        Serializable usuarioRecebido = intent.getSerializableExtra("usuario");
        Usuario usuario = (Usuario) usuarioRecebido;

        TextView txtDetailCidade = (TextView)findViewById(R.id.txtDetailCidade);
        TextView txtDetailEmail = (TextView)findViewById(R.id.txtDetailEmail);
        TextView txtDetailNome = (TextView)findViewById(R.id.txtDetailNome);
        TextView txtDetailTelefone = (TextView)findViewById(R.id.txtDetailTelefone);

        txtDetailNome.setText("Nome: " + usuario.getNome());
        txtDetailCidade.setText("Cidade: " + usuario.getCidade());
        txtDetailEmail.setText("E-mail: " + usuario.getEmail());
        txtDetailTelefone.setText("Telefone: " + usuario.getTelefone());
    }
}
