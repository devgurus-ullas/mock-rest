package com.devgurus.mockrest.entities;

import javax.persistence.*;

@Entity(name = "REQUEST_PARAMS")
public class MockRequestParamEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long paramId;

    @Column
    private String key;

    @Column
    private String value;

    @Column
    private boolean regex;

    @Column
    private boolean enabled;

    public long getParamId() {
        return paramId;
    }

    public void setParamId(long paramId) {
        this.paramId = paramId;
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
