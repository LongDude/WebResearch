package com.proj.webPractic.Controllers;

import com.proj.webPractic.Entity.Exchange;
import com.proj.webPractic.Entity.Trend;
import com.proj.webPractic.repository.TrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trend")
public class TrendController {
    @Autowired
    private TrendRepository trendRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Trend>> getAllTrends(){
        return ResponseEntity.ok(trendRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Trend> addTrend(@RequestBody Trend trend){
        Trend trend_db = trendRepository.save(trend);
        return ResponseEntity.status(HttpStatus.CREATED).body(trend_db);
    }
}
