package com.jp.crypto.alerts.jsonObjects;

public class CoinProfit {

    private String coin;
    private Double start;
    private Double close;
    private Double profit;

    public CoinProfit(String coin, Double start, Double close, Double profit) {
        this.coin = coin;
        this.start = start;
        this.close = close;
        this.profit = profit;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }
}
