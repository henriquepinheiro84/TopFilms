package com.henrique.filmsapp.entity;

public class Filme {
    private boolean adult;
    private String backdrop_path;
    private String overview;
    private String title;
    private int id;
    private String release_date;
    private double vote_average;
    private int vote_count;
    private String poster_path;

    public Filme(boolean adult, String backdrop_path, String overview) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
