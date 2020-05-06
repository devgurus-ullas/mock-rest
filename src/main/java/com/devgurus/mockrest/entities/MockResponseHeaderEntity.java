package com.devgurus.mockrest.entities;

import javax.persistence.*;

@Entity(name = "RESPONSE_HEADERS")
public class MockResponseHeaderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long respHeaderId;

    @Column
    private String key;

    @Column
    private String value;

    @Column
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
