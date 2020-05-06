package com.devgurus.mockrest.models;

import com.devgurus.mockrest.entities.MockRequestHeaderEntity;

import java.util.List;

public class MockRequestModel {

    private long id;

    private String url;

    private String requestMethod;

    private String requestContentType;

    private String requestContent;

    private String responseBody;

    private List<MockRequestHeaderModel> headers;

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

    public List<MockRequestHeaderModel> getHeaders() {
        return headers;
    }

    public void setHeaders(List<MockRequestHeaderModel> headers) {
        this.headers = headers;
    }
}
