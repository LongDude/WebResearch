package com.proj.webPractic.Controllers;

import com.proj.webPractic.Entity.MarketCoin;
import com.proj.webPractic.repository.MarketCoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marketcoins")
public class MarketCoinController {
    @Autowired
    private MarketCoinRepository marketCoinRepository;

    @GetMapping("/all")
    public ResponseEntity<List<MarketCoin>> getAllCoins(){
        return ResponseEntity.ok(marketCoinRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<MarketCoin> addCoin(@RequestBody MarketCoin coin){
        MarketCoin db_coin = marketCoinRepository.save(coin);
        return ResponseEntity.status(HttpStatus.CREATED).body(db_coin);
    }

}
