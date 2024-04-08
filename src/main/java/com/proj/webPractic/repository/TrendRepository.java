package com.proj.webPractic.repository;

import com.proj.webPractic.Entity.Trend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendRepository extends JpaRepository<Trend, String> {
}
