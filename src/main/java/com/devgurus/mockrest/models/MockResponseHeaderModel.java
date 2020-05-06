package com.devgurus.mockrest.models;


public class MockResponseHeaderModel {

    private long respHeaderId;

    private String key;

    private String value;

    private boolean enabled;

    public long getRespHeaderId() {
        return respHeaderId;
    }

    public void setRespHeaderId(long respHeaderId) {
        this.respHeaderId = respHeaderId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
