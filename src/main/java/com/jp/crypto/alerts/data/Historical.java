package com.jp.crypto.alerts.data;

import com.google.gson.Gson;
import com.jp.crypto.alerts.jsonObjects.Coin;
import com.jp.crypto.alerts.jsonObjects.DataInterval;
import com.jp.crypto.alerts.jsonObjects.HistoricalData;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Historical {

    private Environment env;

    public Historical(Environment env) {
        this.env = env;
    }

    public Map<String, HistoricalData> getPump(Map<String, HistoricalData> data){

        Map<String, HistoricalData> pumps = new HashMap<>();

        data.forEach((coin, d) -> {

            if(d.getData().size() > 0) {
                Double start = d.getData().get(0).getOpen();
                Double close = d.getData().get(0).getClose();

                Double plusPercent = (start * 0.1) + start;

                if (close >= plusPercent) {
                    pumps.put(coin, d);
                }
            }
        });

        return pumps;

    }

    public Map<String, HistoricalData> getIncrement15Min(Map<String, HistoricalData> data){

        Map<String, HistoricalData> pumps = new HashMap<>();

        data.forEach((coin, d) -> {

            if(d.getData().size() > 0) {
                Double start = d.getData().get(0).getOpen();
                Double close = d.getData().get(15).getClose();

                Double plusPercent = (start * 0.1) + start;

                if (close >= plusPercent) {
                    pumps.put(coin, d);
                }
            }

        });

        return pumps;
    }

    public Map<String, HistoricalData> getIncrement30Min(Map<String, HistoricalData> data){

        Map<String, HistoricalData> pumps = new HashMap<>();

        data.forEach((coin, d) -> {

            if(d.getData().size() > 0) {
                Double start = d.getData().get(0).getOpen();
                Double close = d.getData().get(30).getClose();

                Double plusPercent = (start * 0.1) + start;

                if (close >= plusPercent) {
                    pumps.put(coin, d);
                }
            }

        });

        return pumps;
    }

    public Map<String, HistoricalData> getIncrement45Min(Map<String, HistoricalData> data){

        Map<String, HistoricalData> pumps = new HashMap<>();

        data.forEach((coin, d) -> {

            if(d.getData().size() > 0) {
                Double start = d.getData().get(0).getOpen();
                Double close = d.getData().get(45).getClose();

                Double plusPercent = (start * 0.1) + start;

                if (close >= plusPercent) {
                    pumps.put(coin, d);
                }
            }

        });

        return pumps;
    }

    public Map<String, HistoricalData> getIncrement1Hour(Map<String, HistoricalData> data){

        Map<String, HistoricalData> pumps = new HashMap<>();

        data.forEach((coin, d) -> {

            if(d.getData().size() > 0) {
                Double start = d.getData().get(0).getOpen();
                Double close = d.getData().get(60).getClose();

                Double plusPercent = (start * 0.01) + start;

                //System.out.println(String.format("%s Start: %.9f --- Close: %.9f --- diff: %.9f", coin, start, close, ((Math.abs(start-close)/start))*100));

                if (close >= plusPercent) {
                    pumps.put(coin, d);
                }
            }

        });

        return pumps;
    }

    public Map<String, HistoricalData> getLastHour(List<Coin> coins){

        Map<String, HistoricalData> dataCoins = new HashMap<>();

        coins.forEach(coin -> {
            RestTemplate restTemplate = new RestTemplate();
            StringBuilder sb = new StringBuilder();
            sb.append(env.getProperty("crypto.info.base.url"));
            sb.append("/").append("histominute?fsym=").append(coin.getSYMBOL());
            sb.append("&tsym=BTC");
            sb.append("&limit=60");
            sb.append("&e=").append(env.getProperty("crypto.info.exchange"));

            String jsonData = restTemplate.getForObject(sb.toString(), String.class);
            HistoricalData lastHour = new Gson().fromJson(jsonData, HistoricalData.class);

            dataCoins.put(coin.getSYMBOL(), lastHour);

        });

        return dataCoins;

    }

}