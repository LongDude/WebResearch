package com.proj.webPractic.repository;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.proj.webPractic.Entity.Deal;
import org.springframework.stereotype.Repository;

@Hidden
@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {
}
