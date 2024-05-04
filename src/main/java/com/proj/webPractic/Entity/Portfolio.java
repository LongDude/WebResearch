package com.proj.webPractic.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="portfolio", schema = "public")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Coin> coins;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Deal> deals;

    @Column(name="profile_volume_usd")
    private double[] profileVolumeUsd;

    @Column(name="profile_volume_btc")
    private double[] profileVolumeBtc;

    @Column(name="current_volume_usd")
    private double currentVolumeUsd;

    @Column(name="current_volume_btc")
    private double currentVolumeBtc;
}
