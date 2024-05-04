package com.proj.webPractic.repository;

import com.proj.webPractic.Entity.Coin;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Hidden
public interface CoinRepository extends JpaRepository<Coin, Long> {
}
