package com.henrique.filmsapp.telainicial.model;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.henrique.filmsapp.entity.Filme;
import com.henrique.filmsapp.entity.Resultado;
import com.henrique.filmsapp.telainicial.presenter.HomePresenter;
import com.henrique.filmsapp.utilidade.Utilidade;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ListaFilmesAsync extends AsyncTask<Void, List<Filme>, List<Filme>> {



    private Context context;
//    private String urlRequest = "https://api.themoviedb.org/3/movie/upcoming?api_key=60fc0288ec3c0c14279f3ec566d452bf&language=pt-BR&page=1";
    private String urlRequest = Utilidade.urlFilmes;
    private String resposta;
    private int pagina;
    private HomePresenter homePresenter;


    public ListaFilmesAsync(Context context, HomePresenter homePresenter, int pagina) {
        this.context = context;
        this.pagina = pagina;
        this.homePresenter = homePresenter;
    }
    @Override
    protected List<Filme> doInBackground(Void... voids) {
        Resultado resultado = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlRequest + pagina)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            resposta = response.body().string();


            resultado = new Gson().fromJson(resposta, Resultado.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resultado != null ? resultado.getResults() : null;
    }

    @Override
    protected void onPostExecute(List<Filme> filmes) {

        this.homePresenter.retornaListaFilmes(filmes);
    }
}
