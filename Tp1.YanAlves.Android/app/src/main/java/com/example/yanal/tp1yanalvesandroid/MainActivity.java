package com.example.yanal.tp1yanalvesandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yanal.tp1yanalvesandroid.Domain.Usuario;
import com.example.yanal.tp1yanalvesandroid.Utils.FileUtil;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FileUtil _fileUtil = new FileUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LimparFormulario(View view)
    {
        List<EditText> campos = new ArrayList<EditText>();

        campos.add((EditText)findViewById(R.id.txtBoxCidade));
        campos.add((EditText)findViewById(R.id.txtBoxEmail));
        campos.add((EditText)findViewById(R.id.txtBoxNome));
        campos.add((EditText)findViewById(R.id.txtBoxTelefone));

        LimparCampos(campos);
    }

    public void SalvarFormulario(View view)
    {
        Usuario usuario = new Usuario();

        EditText txtBoxCidade = (EditText)findViewById(R.id.txtBoxCidade);
        EditText txtBoxEmail = (EditText)findViewById(R.id.txtBoxEmail);
        EditText txtBoxNome = (EditText)findViewById(R.id.txtBoxNome);
        EditText txtBoxTelefone = (EditText)findViewById(R.id.txtBoxTelefone);

        String cidade = txtBoxCidade.getText().toString();
        String email = txtBoxEmail.getText().toString();
        String nome = txtBoxNome.getText().toString();
        String telefone = txtBoxTelefone.getText().toString();

        if (cidade.isEmpty() ||
                email.isEmpty() ||
                nome.isEmpty() ||
                telefone.isEmpty())
        {
            Toast("Preencha todos os campos do formulario");

            return;
        }

        usuario.setCidade(cidade);
        usuario.setEmail(email);
        usuario.setNome(nome);
        usuario.setTelefone(telefone);

        SalvarUsuario(usuario);

        LimparFormulario(view);

        Toast("Usuário salvo com sucesso");

    }

    public void VisualizarUsuarios(View v)
    {
            Intent intent = new Intent(MainActivity.this, Activity_list.class);
            startActivity(intent);
    }

    public void DeletarUsuarios(View v)
    {
        _fileUtil.ZerarArquivo(getBaseContext());
    }

    private void SalvarUsuario(Usuario usuario) {
        String usuarioSerializado = usuario.getNome() + "," +
                                    usuario.getCidade() + "," +
                                    usuario.getEmail() + "," +
                                    usuario.getTelefone() + "-";

        _fileUtil.EscreverLinha(usuarioSerializado, getBaseContext());
    }

    private void LimparCampos(List<EditText> campos)
    {
        for (EditText campo: campos) {
            campo.setText("");
        }
    }

    private void Toast(String mensagem)
    {
        Context contexto = getApplicationContext();
        String texto = mensagem;
        int duracao = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, texto,duracao);
        toast.show();
    }
}
