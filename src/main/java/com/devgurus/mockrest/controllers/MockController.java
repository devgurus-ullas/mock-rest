package com.devgurus.mockrest.controllers;

import com.devgurus.mockrest.entities.MockRequestEntity;
import com.devgurus.mockrest.entities.MockRequestHeaderEntity;
import com.devgurus.mockrest.entities.MockRequestParamEntity;
import com.devgurus.mockrest.entities.MockResponseHeaderEntity;
import com.devgurus.mockrest.services.MockRequestService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/mockserver/**")
public class MockController {

    private MockRequestService mockRequestService;

    public MockController(MockRequestService mockRequestService) {
        this.mockRequestService = mockRequestService;
    }

    @GetMapping
    public ResponseEntity<Object> captureRequestGet(HttpServletRequest request,@RequestHeader HttpHeaders httpHeaders,@RequestParam Map<String, String> parameters){

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping
    public ResponseEntity<Object> captureRequestPost(
            HttpServletRequest request,@RequestHeader HttpHeaders httpHeaders,
            @RequestParam Map<String, String> parameters , @RequestBody(required = false) String requestBody){
        List<MockRequestEntity> results = analyseRequest(request, httpHeaders,parameters,requestBody);
        HttpStatus responseStatus = HttpStatus.OK;
        HttpHeaders responseHeaders = null;
        String responseBody;
        if(results.isEmpty()){
            responseBody="No matching records found!!!";
            responseStatus= HttpStatus.NOT_FOUND;
        }else if (results.size()>1){
            responseBody="multiple ambiguous records found for given inputs !!!";
            responseStatus= HttpStatus.CONFLICT;
        }else{
            MockRequestEntity result = results.get(0);
            responseBody = result.getResponseBody();
            responseHeaders = populateResponseHeaders(result);
        }



        return new ResponseEntity<>(responseBody,responseHeaders,responseStatus);
    }

    private HttpHeaders populateResponseHeaders(MockRequestEntity request){
        HttpHeaders headers = new HttpHeaders();
        List<MockResponseHeaderEntity> mockHeaders = request.getResponseHeaders();
        for (MockResponseHeaderEntity mockHeader : mockHeaders ) {
            headers.add(mockHeader.getKey(),mockHeader.getValue());
        }
        return headers;
    }

    private List<MockRequestEntity> analyseRequest(HttpServletRequest request, HttpHeaders httpHeaders, Map<String, String> parameters , String requestBody){
        String method = request.getMethod();
        String url = request.getRequestURI();
        url = url.substring(12);
        Map<String,String> headerMap=httpHeaders.toSingleValueMap();
        List<MockRequestEntity> results = mockRequestService.findRequests(url, method);

        if(results!=null && !results.isEmpty()){
            results=filterByRequestBody(results,requestBody);
        }

        if(results!=null && !results.isEmpty()){
            results=filterByRequestHeaders(results,headerMap);
        }

        if(results!=null && !results.isEmpty()){
            results=filterByRequestParams(results,parameters);
        }

        return results;
    }

    private List<MockRequestEntity> filterByRequestHeaders(List<MockRequestEntity> results, Map<String, String> headerMap) {
        List<MockRequestEntity> filteredRequests = new ArrayList<>();
        for(MockRequestEntity mockRequest: results){
            List<MockRequestHeaderEntity> mockHeaders = mockRequest.getHeaders();
            if(isAllHeadersPresent(mockHeaders,headerMap)){
                filteredRequests.add(mockRequest);
            }
        }
        return filteredRequests;
    }

    private List<MockRequestEntity> filterByRequestParams(List<MockRequestEntity> results, Map<String, String> headerMap) {
        List<MockRequestEntity> filteredRequests = new ArrayList<>();
        for(MockRequestEntity mockRequest: results){
            List<MockRequestParamEntity> mockRequestParams = mockRequest.getParams();
            if(isAllParamsPresent(mockRequestParams,headerMap)){
                filteredRequests.add(mockRequest);
            }
        }
        return filteredRequests;
    }

    private List<MockRequestEntity> filterByRequestBody(List<MockRequestEntity> results, String requestBody) {
        List<MockRequestEntity> filteredRequests = new ArrayList<>();
        for(MockRequestEntity mockRequest: results){
            String mockRequestBody = mockRequest.getRequestContent();
            if(mockRequestBody == null && requestBody == null ){
                filteredRequests.add(mockRequest);
            }else if(mockRequestBody != null && requestBody!= null && mockRequestBody.equals(requestBody) ){
                    filteredRequests.add(mockRequest);
            }

        }
        return filteredRequests;
    }

    private boolean isAllHeadersPresent(List<MockRequestHeaderEntity> mockHeaders, Map<String, String> headerMap) {

        for(MockRequestHeaderEntity mockHeader: mockHeaders){
            if(!isPresentInMap(headerMap,mockHeader.getKey(),mockHeader.getValue(),mockHeader.isRegex())){
                  return false;
            }
        }
        return true;
    }

    private boolean isAllParamsPresent(List<MockRequestParamEntity> mockHeaders, Map<String, String> headerMap) {

        for(MockRequestParamEntity mockParam: mockHeaders){
            if(!isPresentInMap(headerMap,mockParam.getKey(),mockParam.getValue(),mockParam.isRegex())){
                return false;
            }
        }
        return true;
    }

    private boolean isPresentInMap(Map<String, String> map, String searchKey ,String searchValue,boolean isRegex){

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if(isRegex){
                return true;
            }else {
                if(entry.getKey().equals(searchKey) && entry.getValue().equals(searchValue)){
                    return true;
                }
            }

        }
        return false;
    }


}
