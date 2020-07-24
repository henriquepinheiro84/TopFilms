package com.henrique.filmsapp.telainicial.model;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import retrofit2.Retrofit;

public class ListaFilmesAsync extends AsyncTask<Void, String, String> {

//    Retrofit retrofit = new Retrofit()


    private Context context;
    private String urlTeste = "https://api.themoviedb.org/3/movie/550?api_key=60fc0288ec3c0c14279f3ec566d452bf";

    private String resposta;

    public ListaFilmesAsync(Context context) {
        this.context = context;
    }
    @Override
    protected String doInBackground(Void... voids) {
        RequestQueue requestQueue = Volley.newRequestQueue(this.context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlTeste,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        resposta = response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                resposta = "Deu Ruim!!";
            }
        });
        requestQueue.add(stringRequest);
        return resposta;
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(this.context, resposta, Toast.LENGTH_LONG).show();
    }
}
