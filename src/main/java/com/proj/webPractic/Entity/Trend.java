package com.proj.webPractic.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "trend", schema = "public")
public class Trend {
    @Id
    @Column(name = "coin_name", length = 32, nullable = false)
    private String coinName;

    @Column(name = "coin_code", length = 4)
    private String coinCode;

    @Column(name = "24h")
    private double h24;
}
