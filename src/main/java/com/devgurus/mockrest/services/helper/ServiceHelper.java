package com.devgurus.mockrest.services.helper;

import com.devgurus.mockrest.entities.MockRequestEntity;
import com.devgurus.mockrest.entities.MockRequestHeaderEntity;
import com.devgurus.mockrest.entities.MockRequestParamEntity;
import com.devgurus.mockrest.models.MockRequestHeaderModel;
import com.devgurus.mockrest.models.MockRequestModel;
import com.devgurus.mockrest.models.MockRequestParamModel;
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
            entity.setHeaders(modelToEntityRequestHeaders(model.getHeaders()));
            entity.setParams(modelToEntityRequestParams(model.getParams()));
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
            model.setHeaders(entityToModelRequestHeaders(entity.getHeaders()));
            model.setParams(entityToModelRequestParams(entity.getParams()));
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


    public MockRequestHeaderEntity modelToEntity(MockRequestHeaderModel model){
        if(model != null){
            MockRequestHeaderEntity entity = new MockRequestHeaderEntity();
            entity.setHeaderId(model.getHeaderId());
            entity.setEnabled(model.isEnabled());
            entity.setKey(model.getKey());
            entity.setValue(model.getKey());
            entity.setRegex(model.isRegex());

            return entity;
        }
        return null;
    }

    public MockRequestHeaderModel entityToModel(MockRequestHeaderEntity entity){
        if(entity != null){
            MockRequestHeaderModel model = new MockRequestHeaderModel();
            model.setHeaderId(entity.getHeaderId());
            model.setEnabled(entity.isEnabled());
            model.setKey(entity.getKey());
            model.setValue(entity.getKey());
            model.setRegex(entity.isRegex());

            return model;
        }
        return null;
    }

    public List<MockRequestHeaderEntity> modelToEntityRequestHeaders(List<MockRequestHeaderModel> models){
        List<MockRequestHeaderEntity> entities= new ArrayList<>();
        if(models!= null && !models.isEmpty()){
            for(MockRequestHeaderModel model :models){
                entities.add(modelToEntity(model));
            }
        }
        return entities;
    }

    public List<MockRequestHeaderModel> entityToModelRequestHeaders(List<MockRequestHeaderEntity> entities){
        List<MockRequestHeaderModel> models= new ArrayList<>();
        if(entities!= null && !entities.isEmpty()){
            for(MockRequestHeaderEntity entity  :entities){
                models.add(entityToModel(entity));
            }
        }
        return models;
    }



    public MockRequestParamEntity modelToEntity(MockRequestParamModel model){
        if(model != null){
            MockRequestParamEntity entity = new MockRequestParamEntity();
            entity.setParamId(model.getParamId());
            entity.setEnabled(model.isEnabled());
            entity.setKey(model.getKey());
            entity.setValue(model.getKey());
            entity.setRegex(model.isRegex());
            return entity;
        }
        return null;
    }

    public MockRequestParamModel entityToModel(MockRequestParamEntity entity){
        if(entity != null){
            MockRequestParamModel model = new MockRequestParamModel();
            model.setParamId(entity.getParamId());
            model.setEnabled(entity.isEnabled());
            model.setKey(entity.getKey());
            model.setValue(entity.getKey());
            model.setRegex(entity.isRegex());

            return model;
        }
        return null;
    }

    public List<MockRequestParamEntity> modelToEntityRequestParams(List<MockRequestParamModel> models){
        List<MockRequestParamEntity> entities= new ArrayList<>();
        if(models!= null && !models.isEmpty()){
            for(MockRequestParamModel model :models){
                entities.add(modelToEntity(model));
            }
        }
        return entities;
    }

    public List<MockRequestParamModel> entityToModelRequestParams(List<MockRequestParamEntity> entities){
        List<MockRequestParamModel> models= new ArrayList<>();
        if(entities!= null && !entities.isEmpty()){
            for(MockRequestParamEntity entity  :entities){
                models.add(entityToModel(entity));
            }
        }
        return models;
    }
}
