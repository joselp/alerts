package com.jp.crypto.alerts.controller;

import com.jp.crypto.alerts.data.Historical;
import com.jp.crypto.alerts.data.Info;
import com.jp.crypto.alerts.jsonObjects.Coin;
import com.jp.crypto.alerts.jsonObjects.CoinProfit;
import com.jp.crypto.alerts.jsonObjects.HistoricalData;
import com.jp.crypto.alerts.utils.Exchanges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ProfitController {

    @Autowired
    private Environment env;

    @RequestMapping("/oneHourProfit")
    public List<CoinProfit> oneHourProfit(@RequestParam(value="coin", defaultValue="") String coin) {

        List<CoinProfit> profits = new ArrayList<>();
        Info info = new Info(env);
        List<Coin> coins = null;

        if(env.getProperty("crypto.info.exchange").equals(Exchanges.Poloniex.toString())) {
            coins = info.getPoloniexCoins();
        }

        Historical historical = new Historical(env);

        Map<String, HistoricalData> hourData = historical.getLastHour(coins);

        Map<String, HistoricalData> increment1Hour = historical.getIncrement1Hour(hourData);

        increment1Hour.forEach((c, historicalData) -> {
            double open = historicalData.getData().get(0).getOpen();
            double close = historicalData.getData().get(60).getClose();

            CoinProfit coinProfit = new CoinProfit(c, open, close , ((Math.abs(open-close)/close))*100);
            profits.add(coinProfit);

        });

        return profits;
    }

    @RequestMapping("/fifteenMinProfit")
    public List<CoinProfit> fifteenMinProfit(@RequestParam(value="coin", defaultValue="") String coin) {

        List<CoinProfit> profits = new ArrayList<>();
        Info info = new Info(env);
        List<Coin> coins = null;

        if(env.getProperty("crypto.info.exchange").equals(Exchanges.Poloniex.toString())) {
            coins = info.getPoloniexCoins();
        }

        Historical historical = new Historical(env);

        Map<String, HistoricalData> hourData = historical.getLastHour(coins);

        Map<String, HistoricalData> increment1Hour = historical.getIncrement15Min(hourData);

        increment1Hour.forEach((c, historicalData) -> {
            double open = historicalData.getData().get(0).getOpen();
            double close = historicalData.getData().get(15).getClose();

            CoinProfit coinProfit = new CoinProfit(c, open, close , ((Math.abs(open-close)/close))*100);
            profits.add(coinProfit);

        });

        return profits;
    }

    @RequestMapping("/thirtyMinProfit")
    public List<CoinProfit> thirtyMinProfit(@RequestParam(value="coin", defaultValue="") String coin) {

        List<CoinProfit> profits = new ArrayList<>();
        Info info = new Info(env);
        List<Coin> coins = null;

        if(env.getProperty("crypto.info.exchange").equals(Exchanges.Poloniex.toString())) {
            coins = info.getPoloniexCoins();
        }

        Historical historical = new Historical(env);

        Map<String, HistoricalData> hourData = historical.getLastHour(coins);

        Map<String, HistoricalData> increment1Hour = historical.getIncrement30Min(hourData);

        increment1Hour.forEach((c, historicalData) -> {
            double open = historicalData.getData().get(0).getOpen();
            double close = historicalData.getData().get(30).getClose();

            CoinProfit coinProfit = new CoinProfit(c, open, close , ((Math.abs(open-close)/close))*100);
            profits.add(coinProfit);

        });

        return profits;
    }

    @RequestMapping("/fortyFiveMinProfit")
    public List<CoinProfit> fortyFiveMinProfit(@RequestParam(value="coin", defaultValue="") String coin) {

        List<CoinProfit> profits = new ArrayList<>();
        Info info = new Info(env);
        List<Coin> coins = null;

        if(env.getProperty("crypto.info.exchange").equals(Exchanges.Poloniex.toString())) {
            coins = info.getPoloniexCoins();
        }

        Historical historical = new Historical(env);

        Map<String, HistoricalData> hourData = historical.getLastHour(coins);

        Map<String, HistoricalData> increment1Hour = historical.getIncrement45Min(hourData);

        increment1Hour.forEach((c, historicalData) -> {
            double open = historicalData.getData().get(0).getOpen();
            double close = historicalData.getData().get(45).getClose();

            CoinProfit coinProfit = new CoinProfit(c, open, close , ((Math.abs(open-close)/close))*100);
            profits.add(coinProfit);

        });

        return profits;
    }

}
