package edu.upc.dsa.models;

public class Objeto {
    private String nombre;
    private String info;
    private int coins;

    public Objeto() {}

    public Objeto(String nombre, String info, int coins) {
        this();
        this.nombre=nombre;
        this.info=info;
        this.coins=coins;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
