package com.proj.webPractic.Controllers;

import com.proj.webPractic.Configuration.CoinHistorySheduler;
import com.proj.webPractic.Entity.MarketCoinHistory;
import com.proj.webPractic.repository.MarketCoinHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class CoinHistoryController {
    @Autowired
    private MarketCoinHistoryRepository marketCoinHistoryRepository;
    @Autowired
    private CoinHistorySheduler coinHistorySheduler;

    @GetMapping("list")
    public ResponseEntity<List<MarketCoinHistory>> getHistory(){
        return ResponseEntity.ok(marketCoinHistoryRepository.findAll());
    }

    @GetMapping("last")
    public ResponseEntity<MarketCoinHistory> getLast(){
        return ResponseEntity.ok(marketCoinHistoryRepository.findAll().getLast());
    }

    @GetMapping("update")
    public ResponseEntity<MarketCoinHistory> update(){
        coinHistorySheduler.updateHistory();
        return this.getLast();
    }
}
