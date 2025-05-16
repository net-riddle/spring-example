package com.netriddle.spring_example.model.po;

public class RequestData {
    private String ip;
    private String timestamp;

    public RequestData() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
