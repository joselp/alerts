package com.jp.crypto.alerts.jsonObjects;

public class DataInterval {

    private Long time;
    private Double close;
    private Double high;
    private Double low;
    private Double open;
    private Double volumefrom;
    private Double volumeto;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getVolumefrom() {
        return volumefrom;
    }

    public void setVolumefrom(Double volumefrom) {
        this.volumefrom = volumefrom;
    }

    public Double getVolumeto() {
        return volumeto;
    }

    public void setVolumeto(Double volumeto) {
        this.volumeto = volumeto;
    }

}
