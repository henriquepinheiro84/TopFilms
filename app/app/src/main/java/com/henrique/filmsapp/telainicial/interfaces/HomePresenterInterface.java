package com.henrique.filmsapp.telainicial.interfaces;

import android.content.Context;

import com.henrique.filmsapp.entity.Filme;

import java.util.List;

public interface HomePresenterInterface {

    void listaFilmes(Context context, int pagina);

    void retornaListaFilmes(List<Filme> filmes);
}
