package com.henrique.filmsapp.telainicial.model;

import com.henrique.filmsapp.entity.Filme;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FIlmeInterface {

    @GET
    Call<List<Filme>> getFilmes();
}
