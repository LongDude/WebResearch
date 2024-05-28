package com.proj.webPractic.Configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proj.webPractic.Entity.MarketCoinHistory;
import com.proj.webPractic.repository.MarketCoinHistoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.TimeZone;

@Service
public class CoinHistorySheduler {
    @Autowired
    private MarketCoinHistoryRepository marketCoinHistoryRepository;
    private static final String url = "https://api.coindesk.com/v1/bpi/currentprice.json";

    @Transactional
    @Scheduled(fixedRate = 300000)
    public void updateHistory(){
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = restTemplate.getForObject(url, JsonNode.class);

        Double price_usd = json.path("bpi").path("USD").path("rate_float").doubleValue();
        String time_string = json.path("time").path("updated").asText();
        boolean successful = true;


        Iterator<MarketCoinHistory> it = marketCoinHistoryRepository.findAll().iterator();
        while (marketCoinHistoryRepository.count() > 9){
            MarketCoinHistory old = it.next();
            marketCoinHistoryRepository.deleteById(old.getId());
        }

        MarketCoinHistory record = new MarketCoinHistory(
                price_usd,
                time_string,
                !time_string.isEmpty() && price_usd != 0.0f
        );
        marketCoinHistoryRepository.save(record);

// Not working
//        SimpleDateFormat formatter = new SimpleDateFormat("MMM d, yyyy HH:mm:ss z");
//        Date time;
//        try{
//
//            time = new Date(formatter.parse(time_string).getTime());
//            System.out.println(time);
//        }
//        catch (ParseException e){
//            e.printStackTrace();
//            successful = false;
//            time = new Date(0);
//        }

    }
}
