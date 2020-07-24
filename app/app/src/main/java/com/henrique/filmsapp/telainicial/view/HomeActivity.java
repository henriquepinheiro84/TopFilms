
package com.henrique.filmsapp.telainicial.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.henrique.filmsapp.R;
import com.henrique.filmsapp.entity.Filme;
import com.henrique.filmsapp.telainicial.interfaces.HomeViewInterface;
import com.henrique.filmsapp.telainicial.presenter.HomePresenter;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeViewInterface {

    private HomePresenter homePresenter;
    private int pagina;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.recyclerView = findViewById(R.id.lista_filmes);
        this.pagina = 0;
        this.pagina++;
        this.homePresenter = new HomePresenter(this);
        this.listaFilmes(this, this.pagina);
        findViewById(R.id.btn_proxima_pagina).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pagina++;
                listaFilmes(HomeActivity.this, pagina);
            }
        });
    }

    private void setAdapter(List<Filme> filmes) {
        FilmeAdapter filmeAdapter = new FilmeAdapter(this, filmes);
        recyclerView.setAdapter(filmeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void listaFilmes(Context context, int pagina) {
        homePresenter.listaFilmes(this, pagina);
    }

    @Override
    public void retornaListaFilmes(List<Filme> filmes) {
        if (filmes != null && filmes.size() != 0) {
            this.setAdapter(filmes);
        } else {
            this.pagina = 0;
        }
    }
}