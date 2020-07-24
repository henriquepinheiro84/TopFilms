package com.henrique.filmsapp.teladetalhes.model;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.henrique.filmsapp.entity.Filme;
import com.henrique.filmsapp.interfaces.DetalhesFilmePresenterInterface;
import com.henrique.filmsapp.utilidade.Utilidade;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DetalhesFilmeAsync extends AsyncTask<Void, Filme, Filme> {

    private Context context;
    private DetalhesFilmePresenterInterface detalhesFilmePresenterInterface;
    private int idFilme;

    public DetalhesFilmeAsync(Context context,
                              DetalhesFilmePresenterInterface detalhesFilmePresenterInterface, int idFilme) {
        this.context = context;
        this.detalhesFilmePresenterInterface = detalhesFilmePresenterInterface;
        this.idFilme = idFilme;
    }
    @Override
    protected Filme doInBackground(Void... voids) {
        String urlRequest = Utilidade.urlBase + this.idFilme + Utilidade.apiKey +
                Utilidade.lingua;
        Filme resultado = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlRequest)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String resposta = response.body().string();


            resultado = new Gson().fromJson(resposta, Filme.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    protected void onPostExecute(Filme filme) {
        this.detalhesFilmePresenterInterface.retornaFilmeComDetalhes(filme);

    }
}
