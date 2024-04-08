package com.proj.webPractic.repository;

import com.proj.webPractic.Entity.MarketCoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketCoinRepository extends JpaRepository<MarketCoin, Long> {
}
