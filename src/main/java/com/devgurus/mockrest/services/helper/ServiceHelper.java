package com.devgurus.mockrest.services.helper;

import com.devgurus.mockrest.entities.MockRequestEntity;
import com.devgurus.mockrest.models.MockRequestModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceHelper {

    public MockRequestEntity modelToEntity(MockRequestModel model){
        if(model != null){
            MockRequestEntity entity = new MockRequestEntity();
            entity.setId(model.getId());
            entity.setRequestContent(model.getRequestContent());
            entity.setRequestContentType(model.getRequestContentType());
            entity.setRequestMethod(model.getRequestMethod());
            entity.setResponseBody(model.getResponseBody());
            entity.setUrl(model.getUrl());
            return entity;
        }
        return null;
    }

    public MockRequestModel entityToModel(MockRequestEntity entity){
        if(entity!=null){
            MockRequestModel model = new MockRequestModel();
            model.setId(entity.getId());
            model.setRequestContent(entity.getRequestContent());
            model.setRequestContentType(entity.getRequestContentType());
            model.setRequestMethod(entity.getRequestMethod());
            model.setResponseBody(entity.getResponseBody());
            model.setUrl(entity.getUrl());
            return model;
        }
        return null;
    }

    public List<MockRequestEntity> modelToEntity(List<MockRequestModel> models){
        List<MockRequestEntity> entities= new ArrayList<>();
        if(models!= null && !models.isEmpty()){
            for(MockRequestModel model :models){
                entities.add(modelToEntity(model));
            }
        }
        return entities;
    }

    public List<MockRequestModel> entityToModel(List<MockRequestEntity> entities){
        List<MockRequestModel> models= new ArrayList<>();
        if(entities!= null && !entities.isEmpty()){
            for(MockRequestEntity entity  :entities){
                models.add(entityToModel(entity));
            }
        }
        return models;
    }
}
