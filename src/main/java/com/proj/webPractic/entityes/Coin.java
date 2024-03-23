package com.proj.webPractic.entityes;
public class Coin {

    public Coin(String name, String coin_code, double price, double volume, int[] last_price) {
        this.name = name;
        this.coin_code = coin_code;
        this.price = price;
        this.volume = volume;
        this.last_price = last_price;
    }

    public String name;
    public String coin_code;
    public double price;
    public double volume;
    public int[] last_price;
}
