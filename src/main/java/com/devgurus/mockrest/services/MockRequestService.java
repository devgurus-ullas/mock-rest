package com.devgurus.mockrest.services;

import com.devgurus.mockrest.entities.MockRequestEntity;

import java.util.List;

public interface MockRequestService {

    MockRequestEntity save(MockRequestEntity mockRequestEntity);

    MockRequestEntity update(MockRequestEntity mockRequestEntity);

    MockRequestEntity get(long id);

    List<MockRequestEntity> getAll();

    void delete(long id);

    List<MockRequestEntity> findRequests(String url,String method);

}
