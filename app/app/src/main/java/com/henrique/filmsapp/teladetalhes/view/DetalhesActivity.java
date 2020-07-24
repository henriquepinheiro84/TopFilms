package com.henrique.filmsapp.teladetalhes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.henrique.filmsapp.R;
import com.henrique.filmsapp.entity.Filme;
import com.henrique.filmsapp.interfaces.DetalhesFilmeViewInterface;
import com.henrique.filmsapp.teladetalhes.presenter.DetalhesFilmePresenter;
import com.henrique.filmsapp.utilidade.Utilidade;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import okhttp3.internal.Util;

public class DetalhesActivity extends AppCompatActivity implements DetalhesFilmeViewInterface {

    private DetalhesFilmePresenter detalhesFilmePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Bundle extras = this.getIntent().getExtras();
        int idFilme = extras.getInt("id");
        this.detalhesFilmePresenter = new DetalhesFilmePresenter(this);
        this.detalhesFilmePresenter.recuperaDetalhes(this, idFilme);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void recuperaDetalhes(Context context, int id) {
        this.detalhesFilmePresenter.recuperaDetalhes(context, id);
    }

    @Override
    public void retornaFilmeComDetalhes(Filme filme) {
        ;
        ImageView imagem = findViewById(R.id.img_detalhe);
        TextView titulo = findViewById(R.id.txt_titulo_detalhe);
        TextView descricao = findViewById(R.id.txt_descricao_detalhe);
        TextView votos = findViewById(R.id.txt_votos);
        TextView mediaVotos = findViewById(R.id.txt_media_votos);
        if (filme != null) {
            setTitle(filme.getTitle());
            String urlFoto = Utilidade.urlImagem + filme.getPoster_path();
            Picasso.with(this).load(urlFoto).into(imagem);
            titulo.setText(filme.getTitle());
            descricao.setText(filme.getOverview());
            votos.setText(" " + filme.getVote_count());
            mediaVotos.setText(" " + filme.getVote_count());
        }
    }
}