package com.example.yanal.tp1yanalvesandroid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yanal.tp1yanalvesandroid.Adapter.UsuarioAdapter;
import com.example.yanal.tp1yanalvesandroid.Domain.Usuario;
import com.example.yanal.tp1yanalvesandroid.Utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Activity_list extends AppCompatActivity {
    private ListView _listView;
    private UsuarioAdapter _usuarioAdapter;
    private ProgressDialog load;
    private CarregarUsuarios _carregarUsuarios = new CarregarUsuarios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        _listView = (ListView) findViewById(R.id.lstUsuarios);

        _usuarioAdapter = new UsuarioAdapter(new ArrayList<Usuario>(), this);

        _listView.setEmptyView(findViewById(R.id.listaVazia));
        _listView.setAdapter(_usuarioAdapter);

        _carregarUsuarios.execute();

        _listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Activity_list.this, DetailActivity.class);

                Usuario usuario = _usuarioAdapter.getItem(position);

                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });
    }

    private class CarregarUsuarios extends AsyncTask<Void, Void, List<Usuario>> {

        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(Activity_list.this, "Por favor Aguarde ...", "Buscando informações dos usuários...");
        }

        @Override
        protected List<Usuario> doInBackground(Void... params) {
            List<Usuario> usuarios = new ArrayList<Usuario>();

            FileUtil fileUtil = new FileUtil();

            String conteudoDoArquivo = fileUtil.Ler(getBaseContext());

            if (conteudoDoArquivo == "")
            {
                return usuarios;
            }

            String usuariosEmString[] = conteudoDoArquivo.split("-");

            for (String usuarioNaLista :
                    usuariosEmString) {
                Usuario usuario = new Usuario();
                String partesDoUsuario[] = usuarioNaLista.split(",");

                usuario.setNome(partesDoUsuario[0]);
                usuario.setCidade(partesDoUsuario[1]);
                usuario.setEmail(partesDoUsuario[2]);
                usuario.setTelefone(partesDoUsuario[3]);

                usuarios.add(usuario);
            }

            return usuarios;
        }

        @Override
        protected void onPostExecute(List<Usuario> usuarios){
            super.onPostExecute(usuarios);
            load.dismiss();
            _usuarioAdapter.setItemList(usuarios);
            _usuarioAdapter.notifyDataSetChanged();
        }
    }
}
