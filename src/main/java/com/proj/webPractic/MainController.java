package com.proj.webPractic;

import com.proj.webPractic.entityes.*;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    private final MarketCoin[] coins = new MarketCoin[]{
            new MarketCoin(
                    "Bitcoin",
                    "BTC",
                    50000.0,
                    -25.0,
                    23.0,
                    56.0,
                    2303534050432.0,
                    4395723867.0,
                    new int[]{324,436,584,987,674})
    };
    private final Trend[] trends = new Trend[]{
            new Trend(
                    "Bitcoin",
                    "BTC",
                    23.0
            ),
            new Trend(
                    "Bitcoin",
                    "BTC",
                    23.0
            )
    };
    private final Exchange[] exchanges = new Exchange[]{
            new Exchange(
                    "Binance",
                    9.0,
                    364578658725L,
                    67,
                    45,
                    new int[]{324,436,584,987,674}
            )
    };

    private final Portfolio portfolio = new Portfolio();

    @PostConstruct
    public void initPortfolio() {
        this.portfolio.addCoin(
                new Coin(
                        "Bitcoin",
                        "BTC",
                        34.0,
                        3289476278.0,
                        new int[]{324, 436, 584, 987, 674}
                )
        );
        this.portfolio.addDeal(
                new Deal(
                        "2024-02-02T12:33:33",
                        "sell",
                        3543256.0,
                        3.0,
                        "Bitcoin",
                        "BTC"
                )
        );
        this.portfolio.setCurrent_volume_btc(345.0);
        this.portfolio.setCurrent_volume_usd(345.0);
        this.portfolio.setProfile_volume_bts(new double[]{324.0,436.0,584.0,987.0,674.0});
        this.portfolio.setProfile_volume_usd(new double[]{324.0,436.0,584.0,987.0,674.0});
    }

    @GetMapping("/coins")
    public Coin[] get_coins(Model model) {
        return this.coins;
    }
    @GetMapping("/trends")
    public Trend[] get_trends(Model model) {
        return this.trends;
    }
    @GetMapping("/exchanges")
    public Exchange[] get_exchanges(Model model) {
        return this.exchanges;
    }
    @GetMapping("/portfolio")
    public Portfolio get_portfolio(Model model) {
        return this.portfolio;
    }

    @PostMapping("/add-deal")
    public Deal add_deal(@RequestBody Deal deal){
        this.portfolio.addDeal(deal);
        return deal;
    }
}

