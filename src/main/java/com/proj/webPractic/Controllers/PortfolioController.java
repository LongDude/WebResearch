package com.proj.webPractic.Controllers;

import com.proj.webPractic.Entity.Coin;
import com.proj.webPractic.Entity.Deal;
import com.proj.webPractic.Entity.Portfolio;
import com.proj.webPractic.repository.CoinRepository;
import com.proj.webPractic.repository.DealRepository;
import com.proj.webPractic.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private CoinRepository coinRepository;
    @Autowired
    private DealRepository dealRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Portfolio>> getAllPortfolio(){
        return ResponseEntity.ok(portfolioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getById(@PathVariable Long id){
        Optional<Portfolio> portfolio = portfolioRepository.findById(id);
        return portfolio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Portfolio> addPortfolio(@RequestBody Portfolio portfolio){
        Portfolio portfolio_db = portfolioRepository.save(portfolio);
        return ResponseEntity.status(HttpStatus.CREATED).body(portfolio_db);
    }
    @GetMapping("/{portId}/get-deals")
    public ResponseEntity<List<Deal>> getDealsByPortId(@PathVariable Long portId){
        Optional<Portfolio> portfolio = portfolioRepository.findById(portId);
        return portfolio.map(value -> ResponseEntity.ok(value.getDeals())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{portId}/add-deal")
    public ResponseEntity<Deal> addDeal(@PathVariable Long portId, @RequestBody Deal deal){
        Optional<Portfolio> portfolio = portfolioRepository.findById(portId);
        if (portfolio.isPresent()){
            deal.setPortfolio(portfolio.get());
            Deal deal_db = dealRepository.save(deal);
            return ResponseEntity.ok(deal_db);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{portId}/get-coins")
    public ResponseEntity<List<Coin>> getCoinsByPortId(@PathVariable Long portId){
        Optional<Portfolio> portfolio = portfolioRepository.findById(portId);
        return portfolio.map(value -> ResponseEntity.ok(value.getCoins())).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/{portId}/add-coin")
    public ResponseEntity<Coin> addCoin(@PathVariable Long portId, @RequestBody Coin coin){
        Optional<Portfolio> portfolio = portfolioRepository.findById(portId);
        if (portfolio.isPresent()){
            coin.setPortfolio(portfolio.get());
            Coin coin_db = coinRepository.save(coin);
            return ResponseEntity.ok(coin_db);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
