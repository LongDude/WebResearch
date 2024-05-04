package com.proj.webPractic.repository;

import com.proj.webPractic.Entity.Trend;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Hidden
@Repository
public interface TrendRepository extends JpaRepository<Trend, String> {
}
