package com.proj.webPractic.repository;

import com.proj.webPractic.Entity.Portfolio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PortfolioRepositoryTest {
    @Autowired PortfolioRepository portfolioRepository;

    @Test
    void addPortfolio(){
        Portfolio portfolio = Portfolio.builder()
                .profileVolumeBtc(List.of(1.0, 2.0, 3.0))
                .profileVolumeUsd(List.of(2.0, 3.0, 4.0))
                .currentVolumeBtc(List.of(3.0, 4.0))
                .currentVolumeUsd(List.of(5.0, 6.0))
                .build();
        portfolioRepository.save(portfolio);
    }
}