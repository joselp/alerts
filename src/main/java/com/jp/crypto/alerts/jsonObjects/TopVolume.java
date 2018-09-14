package com.jp.crypto.alerts.jsonObjects;

import java.util.List;

public class TopVolume {

    private List<Coin> Data;

    public TopVolume() {
    }

    public TopVolume(List<Coin> Data) {
        this.Data = Data;
    }

    public List<Coin> getData() {
        return Data;
    }

    public void setData(List<Coin> data) {
        Data = data;
    }
}
