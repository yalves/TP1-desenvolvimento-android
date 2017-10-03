package com.example.yanal.tp1yanalvesandroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.yanal.tp1yanalvesandroid.Domain.Usuario;
import com.example.yanal.tp1yanalvesandroid.R;

import java.util.List;

/**
 * Created by yanal on 03/10/2017.
 */

public class UsuarioAdapter extends ArrayAdapter<Usuario>
{
    private List<Usuario> _usuarios;
    private Context context;

    public UsuarioAdapter(List<Usuario> usuarios, Context context)
    {
        super(context, R.layout.layout_list, R.id.lstUsuarios, usuarios);
        this._usuarios = usuarios;
        this.context = context;
    }

    public int getCount()
    {
        if (_usuarios != null)
            return _usuarios.size();
        return 0;
    }

    public Usuario getItem(int position)
    {
        if (_usuarios != null)
            return _usuarios.get(position);
        return null;
    }

    public long getItemId(int position)
    {
        if(_usuarios != null)
            return _usuarios.get(position).hashCode();
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_list, null);
        }

        Usuario character = _usuarios.get(position);
        TextView t1 = (TextView) view.findViewById(R.id.txtNameList);
        t1.setText(character.getNome());

        return view;
    }

    public void setItemList(List<Usuario> usuarios)
    {
        this._usuarios = usuarios;
    }
}
