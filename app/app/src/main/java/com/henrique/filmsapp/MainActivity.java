package com.henrique.filmsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.henrique.filmsapp.telainicial.presenter.HomePresenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomePresenter homePresenter = new HomePresenter();
        homePresenter.listaFilmes(this);
    }
}