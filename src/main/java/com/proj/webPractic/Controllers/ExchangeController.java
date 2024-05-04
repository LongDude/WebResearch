package com.proj.webPractic.Controllers;

import com.proj.webPractic.Entity.Exchange;
import com.proj.webPractic.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchanges")
public class ExchangeController {
    @Autowired
    private ExchangeRepository exchangeRepository;

    @GetMapping("all")
    public ResponseEntity<List<Exchange>> getAllExchanges(){
        return ResponseEntity.ok(exchangeRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Exchange> addExchange(@RequestBody Exchange exchange){
        Exchange exchange_db = exchangeRepository.save(exchange);
        return ResponseEntity.status(HttpStatus.CREATED).body(exchange_db);
    }
}
