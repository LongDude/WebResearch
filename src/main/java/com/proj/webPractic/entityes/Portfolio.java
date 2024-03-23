package com.proj.webPractic.entityes;
import java.util.ArrayList;
public class Portfolio {
    public Portfolio(){
        this.coins = new ArrayList<>();
        this.deals = new ArrayList<>();
    }
    public ArrayList<Coin> coins;
    public ArrayList<Deal> deals;
    public double[] getProfile_volume_usd() {
        return profile_volume_usd;
    }
    public void setProfile_volume_usd(double[] profile_volume_usd) {
        this.profile_volume_usd = profile_volume_usd;
    }
    public double[] getProfile_volume_bts() {
        return profile_volume_bts;
    }
    public void setProfile_volume_bts(double[] profile_volume_bts) {
        this.profile_volume_bts = profile_volume_bts;
    }
    public double getCurrent_volume_usd() {
        return current_volume_usd;
    }
    public void setCurrent_volume_usd(double current_volume_usd) {
        this.current_volume_usd = current_volume_usd;
    }
    public double getCurrent_volume_btc() {
        return current_volume_btc;
    }
    public void setCurrent_volume_btc(double current_volume_btc) {
        this.current_volume_btc = current_volume_btc;
    }
    private double[] profile_volume_usd;
    private double[] profile_volume_bts;
    private double current_volume_usd;
    private double current_volume_btc;
    public void addCoin(Coin coin){
        this.coins.add(coin);
    }
    public void addDeal(Deal deal){
        this.deals.add(deal);
    }
}
