package com.proj.webPractic.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "coin_history")
public class MarketCoinHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "price_usd")
    private Double price_usd;

    @Column(name = "time")
    private String date;

    @Column(name = "update_successful")
    private Boolean update_successful;

    public MarketCoinHistory(Double price_usd, String date, Boolean update_successful) {
        this.price_usd = price_usd;
        this.date = date;
        this.update_successful = update_successful;
    }
}
