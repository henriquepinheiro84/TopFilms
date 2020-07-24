package com.henrique.filmsapp;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.henrique.filmsapp.telainicial.presenter.HomePresenter;
import com.henrique.filmsapp.telainicial.view.HomeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        HomePresenter homePresenter = new HomePresenter();
//        homePresenter.listaFilmes(this);
        WebView webView = findViewById(R.id.web_view);
        webView.loadUrl("https://api.themoviedb.org/3/movie/550?api_key=60fc0288ec3c0c14279f3ec566d452bf");
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}