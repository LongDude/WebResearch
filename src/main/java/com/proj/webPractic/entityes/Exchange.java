package com.proj.webPractic.entityes;

public class Exchange {
    public Exchange(
            String name, double score, long volume24h,
            double markets, double coins, int[] last_volume
    ){
        this.name = name;
        this.score = score;
        this.volume24h = volume24h;
        this.markets = markets;
        this.coins = coins;
        this.last_volume = last_volume;
    }

    public String name;
    public double score;
    public long volume24h;
    public double markets;
    public double coins;
    public int[] last_volume;
}
