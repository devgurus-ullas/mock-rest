package com.devgurus.mockrest.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "REQUESTS")
public class MockRequestEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String url;

    @Column
    private String requestMethod;

    @Column
    private String requestContentType;

    @Column
    private String requestContent;

    @Column
    private String responseBody;

    @OneToMany(cascade=CascadeType.ALL)
    private List<MockRequestHeaderEntity> headers;

    @OneToMany(cascade=CascadeType.ALL)
    private List<MockRequestParamEntity> params;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestContentType() {
        return requestContentType;
    }

    public void setRequestContentType(String requestContentType) {
        this.requestContentType = requestContentType;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public List<MockRequestHeaderEntity> getHeaders() {
        return headers;
    }

    public void setHeaders(List<MockRequestHeaderEntity> headers) {
        this.headers = headers;
    }

    public List<MockRequestParamEntity> getParams() {
        return params;
    }

    public void setParams(List<MockRequestParamEntity> params) {
        this.params = params;
    }
}
