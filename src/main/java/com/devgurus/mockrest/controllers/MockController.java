package com.devgurus.mockrest.controllers;

import com.devgurus.mockrest.entities.MockRequestEntity;
import com.devgurus.mockrest.entities.MockRequestHeaderEntity;
import com.devgurus.mockrest.entities.MockRequestParamEntity;
import com.devgurus.mockrest.models.MockRequestModel;
import com.devgurus.mockrest.services.MockRequestService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/mockserver/**")
public class MockController {

    private MockRequestService mockRequestService;

    public MockController(MockRequestService mockRequestService) {
        this.mockRequestService = mockRequestService;
    }

    @GetMapping
    public ResponseEntity<Object> captureRequestGet(HttpServletRequest request,@RequestHeader HttpHeaders httpHeaders){
        analyseRequest(request,httpHeaders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping
    public ResponseEntity<Object> captureRequestPost(HttpServletRequest request,@RequestHeader HttpHeaders httpHeaders){
        analyseRequest(request,httpHeaders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private List<MockRequestEntity> analyseRequest(HttpServletRequest request,HttpHeaders httpHeaders){
        String method = request.getMethod();
        String url = request.getRequestURI();
        url = url.substring(12);

        Map<String,String> headerMap=httpHeaders.toSingleValueMap();

        List<MockRequestEntity> results = mockRequestService.findRequests(url, method);
        System.out.println(method + "-" + url);
        System.out.println(results.size());
        results=filterByRequestHeaders(results,headerMap);
        System.out.println("After filter result!!!");
        System.out.println(results.size());
        return null;
    }

    private List<MockRequestEntity> filterByRequestHeaders(List<MockRequestEntity> results, Map<String, String> headerMap) {
        List<MockRequestEntity> filteredRequests = new ArrayList<>();
        for(MockRequestEntity request: results){
            List<MockRequestHeaderEntity> headers = request.getHeaders();
            Stream<MockRequestHeaderEntity> activeHeaders = headers.stream().filter(h -> h.isEnabled());
            activeHeaders.

        }
        return filteredRequests;
    }

    private boolean isPresentInMap(Map<String, String> map, String searchKey ,String searchValue){

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if(entry.getKey().equals(searchKey) && entry.getValue().equals(searchValue)){
                return true;
            }
        }
        return false;
    }


}
