package com.henrique.filmsapp.interfaces;

import android.content.Context;

import com.henrique.filmsapp.entity.Filme;

public interface DetalhesFilmePresenterInterface {
    void recuperaDetalhes(Context context, int id);

    void retornaFilmeComDetalhes(Filme filme);

}
