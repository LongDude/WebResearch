package com.proj.webPractic.Entity;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.math.BigInteger;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="exchange", schema = "public")
public class Exchange {

    @Id
    @Column(name = "exchange_name", length = 20, nullable = false)
    private String exchangeName;

    @Column(name = "score")
    private double score;
    @Column(name="volume24h")
    private long volume24h;

    @Column(name="markets")
    private long markets;

    @Column(name = "coins")
    private long coins;

    @Type(ListArrayType.class)
    @Column(columnDefinition = "integer[]", name="last_volume")
    private List<Integer> lastVolume;
}
