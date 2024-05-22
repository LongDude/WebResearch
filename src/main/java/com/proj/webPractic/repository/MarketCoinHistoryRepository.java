package com.proj.webPractic.repository;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Hidden
@Repository
public interface MarketCoinHistoryRepository extends JpaRepository<com.proj.webPractic.Entity.MarketCoinHistory, Long> {

}
