package com.devgurus.mockrest.services.impl;

import com.devgurus.mockrest.entities.MockRequestEntity;
import com.devgurus.mockrest.repositories.MockRequestDAO;
import com.devgurus.mockrest.services.MockRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockRequestServiceImpl implements MockRequestService {

    private MockRequestDAO requestDAO;

    public MockRequestServiceImpl(MockRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    @Override
    public MockRequestEntity save(MockRequestEntity mockRequestEntity) {
        return requestDAO.save(mockRequestEntity);
    }

    @Override
    public MockRequestEntity update(MockRequestEntity mockRequestEntity) {
        return requestDAO.save(mockRequestEntity);
    }

    @Override
    public MockRequestEntity get(long id) {
        return requestDAO.getOne(id);
    }

    @Override
    public List<MockRequestEntity> getAll() {
        return requestDAO.findAll();
    }

    @Override
    public void delete(long id) {
        requestDAO.deleteById(id);
    }

    @Override
    public List<MockRequestEntity> findRequests(String url, String method) {
        return requestDAO.findAllByUrlAndRequestMethod(url,method);
    }



}
