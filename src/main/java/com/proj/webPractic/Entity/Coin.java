package com.proj.webPractic.Entity;

import com.fasterxml.jackson.annotation.*;
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
@Table(name="coin", schema="public")
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="portfolio_id", nullable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Portfolio portfolio;

    @Column(length = 32, name="coin_name")
    private String coinName;
    @Column(length = 4, name = "coin_code")
    private String coinCode;
    private double price;
    private double volume;
    @Type(ListArrayType.class)
    @Column(columnDefinition = "integer[]", name="last_price")
    private List<Integer> lastPrice;
}
