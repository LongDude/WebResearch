package com.proj.webPractic.Entity;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "coin_market_info", schema = "public")
public class MarketCoin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "1h")
    private double diff1h;
    @Column(name = "24h")
    private double diff24h;
    @Column(name = "7d")
    private double diff7d;
    @Column(name = "market_cap")
    private double marketCap;
    @Column(length = 32, name="coin_name")
    private String coinName;
    @Column(length = 4, name = "coin_code")
    private String coinCode;
    @Column
    private double price;
    @Column
    private double volume;
    @Type(ListArrayType.class)
    @Column(columnDefinition = "integer[]", name="last_price")
    private List<Integer> lastPrice;
}
