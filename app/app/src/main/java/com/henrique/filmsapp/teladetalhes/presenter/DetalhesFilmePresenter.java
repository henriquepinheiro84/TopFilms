package com.henrique.filmsapp.teladetalhes.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.henrique.filmsapp.entity.Filme;
import com.henrique.filmsapp.interfaces.DetalhesFilmePresenterInterface;
import com.henrique.filmsapp.interfaces.DetalhesFilmeViewInterface;
import com.henrique.filmsapp.teladetalhes.model.DetalhesFilmeAsync;

public class DetalhesFilmePresenter implements DetalhesFilmePresenterInterface {
    DetalhesFilmeViewInterface detalhesFilmeViewInterface;
    public DetalhesFilmePresenter(DetalhesFilmeViewInterface detalhesFilmeViewInterface) {
        this.detalhesFilmeViewInterface = detalhesFilmeViewInterface;
    }
    @Override
    public void recuperaDetalhes(Context context, int id) {
        new DetalhesFilmeAsync(context, this, id).
                executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void retornaFilmeComDetalhes(Filme filme) {
        this.detalhesFilmeViewInterface.retornaFilmeComDetalhes(filme);
    }
}
