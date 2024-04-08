package com.proj.webPractic.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "deal", schema = "public")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="portfolio_id", nullable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Portfolio portfolio;

    @Column(name = "date")
    private Date date;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private DealType type;

    @Column(name = "price")
    private double price;

    @Column(name = "volume")
    private double volume;

    @Column(name="coin_code", length = 4)
    private String coinCode;

    @Column(name="coin_name", length = 32)
    private String coinName;
}
