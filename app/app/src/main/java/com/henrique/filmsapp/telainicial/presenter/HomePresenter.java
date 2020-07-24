package com.henrique.filmsapp.telainicial.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.henrique.filmsapp.entity.Filme;
import com.henrique.filmsapp.telainicial.interfaces.HomePresenterInterface;
import com.henrique.filmsapp.telainicial.interfaces.HomeViewInterface;
import com.henrique.filmsapp.telainicial.model.ListaFilmesAsync;

import java.util.List;

public class HomePresenter implements HomePresenterInterface {
    private  HomeViewInterface homeViewInterface;

    public HomePresenter(HomeViewInterface homeViewInterface) {
        this.homeViewInterface = homeViewInterface;
    }
    @Override
    public void listaFilmes(Context context, int pagina) {

        new ListaFilmesAsync(context, this, pagina).
                executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void retornaListaFilmes(List<Filme> filmes) {
        this.homeViewInterface.retornaListaFilmes(filmes);
    }
}
