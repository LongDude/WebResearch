package com.proj.webPractic.entityes;

public class MarketCoin extends Coin{
    public double diff_1h;
    public double diff_24h;
    public double diff_7d;
    public double market_cap;
    public MarketCoin(
            String name, String coin_code, double price,
            double diff_1h, double diff_24h, double diff_7d,
            double market_cap, double volume, int[] last_price
    ){
        super(name, coin_code, price, volume, last_price);
        this.diff_1h = diff_1h;
        this.diff_24h = diff_24h;
        this.diff_7d = diff_7d;
        this.market_cap = market_cap;
    }
}
