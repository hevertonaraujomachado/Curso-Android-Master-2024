package com.devheverton.whatsapplist.Adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devheverton.whatsapplist.Model.Usuario;
import com.devheverton.whatsapplist.R;

import java.util.ArrayList;
import java.util.List;

public  class AdapterUsuario extends RecyclerView.Adapter<AdapterUsuario.UsuarioViewHolder> {

    private List<Usuario> usuarioList = new ArrayList<>();

    public AdapterUsuario(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        itemLista = layoutInflater.inflate(R.layout.usuario_item,parent, false);
        return new UsuarioViewHolder(itemLista);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterUsuario.UsuarioViewHolder holder, int position){
        holder.foto.setImageResource(usuarioList.get(position).getFoto());
        holder.nome.setText(usuarioList.get(position).getNome());
        holder.mensagem.setText(usuarioList.get(position).getMensagem());

    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private TextView nome;
        private TextView mensagem;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.fotoUsuario);
            nome = itemView.findViewById(R.id.nomeUsuario);
            mensagem = itemView.findViewById(R.id.mensagemUsuario);
        }
    }
}
