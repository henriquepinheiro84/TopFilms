package com.henrique.filmsapp.telainicial.interfaces;

import android.content.Context;

public interface HomePresenterInterface {
    void listaFilmes(Context context);
    void retornaListaFilmes(String json);
}
