package com.henrique.filmsapp.entity;

public class Filme {
    private boolean adult;
    private String backdrop_path;
    private String overview;

    public Filme(boolean adult, String backdrop_path, String overview) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getOverview() {
        return overview;
    }
}
