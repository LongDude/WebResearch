package com.proj.webPractic.entityes;


public class Deal {
    public Deal(
            String date, String type, double price,
            double volume, String coin_name, String coin_code
    ){
        this.date = date;
        this.type = type;
        this.price = price;
        this.volume = volume;
        this.coin_name = coin_name;
        this.coin_code = coin_code;
    }

    public String date;
    public String type;
    public double price;
    public double volume;
    public String coin_name;
    public String coin_code;
}
