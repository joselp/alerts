package com.jp.crypto.alerts.jsonObjects;

public class Coin {

    private String SYMBOL;
    private Double SUPPLY;
    private String FULLNAME;
    private String NAME;
    private String ID;
    private Double VOLUME24HOURTO;

    public Coin() {
    }

    public Coin(String SYMBOL, Double SUPPLY, String FULLNAME, String NAME, String ID, Double VOLUME24HOURTO) {
        this.SYMBOL = SYMBOL;
        this.SUPPLY = SUPPLY;
        this.FULLNAME = FULLNAME;
        this.NAME = NAME;
        this.ID = ID;
        this.VOLUME24HOURTO = VOLUME24HOURTO;
    }

    public Coin(String SYMBOL) {
        this.SYMBOL = SYMBOL;
    }

    public String getSYMBOL() {
        return SYMBOL;
    }

    public void setSYMBOL(String SYMBOL) {
        this.SYMBOL = SYMBOL;
    }

    public Double getSUPPLY() {
        return SUPPLY;
    }

    public void setSUPPLY(Double SUPPLY) {
        this.SUPPLY = SUPPLY;
    }

    public String getFULLNAME() {
        return FULLNAME;
    }

    public void setFULLNAME(String FULLNAME) {
        this.FULLNAME = FULLNAME;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Double getVOLUME24HOURTO() {
        return VOLUME24HOURTO;
    }

    public void setVOLUME24HOURTO(Double VOLUME24HOURTO) {
        this.VOLUME24HOURTO = VOLUME24HOURTO;
    }
}
