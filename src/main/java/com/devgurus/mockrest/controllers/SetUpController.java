package com.devgurus.mockrest.controllers;

import com.devgurus.mockrest.entities.MockRequestEntity;
import com.devgurus.mockrest.models.MockRequestModel;
import com.devgurus.mockrest.services.MockRequestService;
import com.devgurus.mockrest.services.helper.ServiceHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "httprequests")
public class SetUpController {

    private MockRequestService requestService;

    private ServiceHelper serviceHelper;


    public SetUpController(MockRequestService requestService, ServiceHelper serviceHelper) {
        this.requestService = requestService;
        this.serviceHelper = serviceHelper;
    }

    @PostMapping
    @PutMapping
    public ResponseEntity<Void> saveHttpRequest(@RequestBody MockRequestModel mockRequestModel){
        MockRequestEntity mockRequestEntity = serviceHelper.modelToEntity(mockRequestModel);
        requestService.save(mockRequestEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{requestId}")
    public ResponseEntity<MockRequestModel> getHttpRequest(@PathVariable long requestId ){
        MockRequestEntity entity = requestService.get(requestId);
        MockRequestModel model = serviceHelper.entityToModel(entity);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MockRequestModel>> getHttpRequests(){
        List<MockRequestEntity> entities = requestService.getAll();
        List<MockRequestModel> models = serviceHelper.entityToModel(entities);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{requestId}")
    public ResponseEntity<Void> deleteHttpRequest(@PathVariable long requestId ){
        requestService.delete(requestId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
