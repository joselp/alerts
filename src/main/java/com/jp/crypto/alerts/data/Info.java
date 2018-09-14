package com.jp.crypto.alerts.data;

import com.google.gson.Gson;
import com.jp.crypto.alerts.jsonObjects.Coin;
import com.jp.crypto.alerts.jsonObjects.Price;
import com.jp.crypto.alerts.jsonObjects.TopVolume;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Info {

    private Environment env;

    public Info(Environment env) {
        this.env = env;
    }

    public Double getPriceBTC(){

        RestTemplate restTemplate = new RestTemplate();
        String price = restTemplate.getForObject(String.format("%s/%s&e=%s", env.getProperty("crypto.info.base.url"), "price?fsym=BTC&tsyms=USD",
                env.getProperty("crypto.info.exchange")), String.class);

        return new Gson().fromJson(price, Price.class).getUSD();

    }

    public List<Coin> getTopVolume(){

        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(String.format("%s/%s%s", env.getProperty("crypto.info.base.url"),
                "top/volumes?tsym=BTC&limit=", env.getProperty("crypto.info.limit")), String.class);

        TopVolume topVolume = new Gson().fromJson(json, TopVolume.class);

        return topVolume.getData();
    }

    public String getTopVolumeAsString(List<Coin> coins){

        StringBuilder cString = new StringBuilder();

        coins.forEach(coin -> cString.append(coin).append(","));

        cString.deleteCharAt(cString.length()-1);

        return cString.toString();
    }

    public List<Coin> getPoloniexCoins(){

        String coins = env.getProperty("crypto.coins.poloniex");
        List<Coin> coinList = new ArrayList<>();

        for (String coin : coins.split(",")) {
            coinList.add(new Coin(coin));
        }

        return coinList;
    }

}
