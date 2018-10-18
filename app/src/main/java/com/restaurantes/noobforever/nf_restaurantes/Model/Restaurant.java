package com.restaurantes.noobforever.nf_restaurantes.Model;

public class Restaurant {
    String nombre, direccion, categoria,urlFoto;
    double lat, lon;
    int rating;

    public Restaurant(String nombre, String direccion, String categoria, String urlFoto, int rating, double lat, double lon) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.categoria = categoria;
        this.urlFoto = urlFoto;
        this.lat = lat;
        this.lon = lon;
        this.rating = rating;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getUrlFoto() {
        return urlFoto;
    }
    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
