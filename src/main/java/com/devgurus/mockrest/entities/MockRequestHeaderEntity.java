package com.devgurus.mockrest.entities;

import javax.persistence.*;

@Entity(name = "REQUEST_HEADERS")
public class MockRequestHeaderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long headerId;

    @Column
    private String key;

    @Column
    private String value;

    @Column
    private boolean regex;

    @Column
    private boolean enabled;

    public long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(long headerId) {
        this.headerId = headerId;
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

    public boolean isRegex() {
        return regex;
    }

    public void setRegex(boolean regex) {
        this.regex = regex;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
