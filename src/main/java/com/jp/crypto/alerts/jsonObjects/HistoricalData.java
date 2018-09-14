package com.jp.crypto.alerts.jsonObjects;

import java.util.List;

public class HistoricalData {

    private String Response;
    private Integer Type;
    private Boolean Aggregated;
    List<DataInterval> Data;
    private Long TimeTo;
    private Long TimeFrom;

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public Boolean getAggregated() {
        return Aggregated;
    }

    public void setAggregated(Boolean aggregated) {
        Aggregated = aggregated;
    }

    public List<DataInterval> getData() {
        return Data;
    }

    public void setData(List<DataInterval> data) {
        Data = data;
    }

    public Long getTimeTo() {
        return TimeTo;
    }

    public void setTimeTo(Long timeTo) {
        TimeTo = timeTo;
    }

    public Long getTimeFrom() {
        return TimeFrom;
    }

    public void setTimeFrom(Long timeFrom) {
        TimeFrom = timeFrom;
    }
}
