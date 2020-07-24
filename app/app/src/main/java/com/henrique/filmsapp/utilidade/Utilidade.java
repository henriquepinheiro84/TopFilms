package com.henrique.filmsapp.utilidade;

public class Utilidade {
    public static String apiKey = "?api_key=ENTRE_COM_SUA_CHAVE";
    public static String urlBase = "https://api.themoviedb.org/3/movie/";
    public static String paraLancar = "upcoming";
    public static String lingua = "&language=pt-BR";
    public static String pagina = "&page=";
    public static String urlFilmes = urlBase + paraLancar + apiKey + lingua + pagina;

    public static String urlImagem = "https://image.tmdb.org/t/p/w185/";
}
