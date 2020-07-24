package com.henrique.filmsapp.telainicial.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.henrique.filmsapp.R;
import com.henrique.filmsapp.entity.Filme;
import com.henrique.filmsapp.teladetalhes.view.DetalhesActivity;
import com.henrique.filmsapp.utilidade.Utilidade;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder> {

    private Context context;
    private List<Filme> filmes;
    //Criar construtor

    public FilmeAdapter(Context context, List<Filme> filmes) {
        this.context = context;
        this.filmes = filmes;
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_filme, parent, false);
        return new FilmeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, final int position) {
        holder.titulo.setText(filmes.get(position).getTitle());
        holder.resumo.setText(filmes.get(position).getOverview());
        String urlFoto = Utilidade.urlImagem + filmes.get(position).getBackdrop_path();
        Picasso.with(context).load(urlFoto).into(holder.imagem);
        holder.listaFilmeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abre a tela de detalhoes do filme.
                Intent intent = new Intent(context, DetalhesActivity.class);
                intent.putExtra("id", filmes.get(position).getId());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView resumo;
        ImageView imagem;
        View listaFilmeItem;


        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txt_titulo);
            resumo = itemView.findViewById(R.id.txt_resumo);
            imagem = itemView.findViewById(R.id.img_filme);
            listaFilmeItem = itemView.findViewById(R.id.lista_filmes_item);
        }
    }
}
