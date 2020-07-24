package com.henrique.filmsapp.telainicial.presenter;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.os.AsyncTask;

import com.henrique.filmsapp.telainicial.interfaces.HomePresenterInterface;
import com.henrique.filmsapp.telainicial.model.ListaFilmesAsync;

public class HomePresenter implements HomePresenterInterface {

    @Override
    public void listaFilmes(Context context) {
        new ListaFilmesAsync(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void retornaListaFilmes(String json) {

    }
}
