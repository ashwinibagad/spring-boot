package com.mockserver.demo.controller;

import com.mockserver.demo.data.API;
import com.mockserver.demo.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class APIController {

    @Autowired
    private APIService apiService;

    @GetMapping("/mockserver")
    private List<API> getAPIs(){
        return this.apiService.getAPIs();
    }

    @GetMapping("/mockserver/{endpointName}")
    private ResponseEntity<String> getAPI(@PathVariable String endpointName){
        API api = this.apiService.getAPI(endpointName);
        return new ResponseEntity<String>(api.getResponseBody(), HttpStatus.valueOf(api.getHttpCode()));
    }

    @PostMapping(path="/mockserver", consumes="application/json")
    private API addAPI(@RequestBody API api)
    {
        api.uuid = UUID.randomUUID().toString();
        return this.apiService.addAPI(api);
    }

    @PutMapping("/mockserver/{endpointName}")
    private API updateAPI(@RequestBody API api, @PathVariable String endpointName){
        return this.apiService.updateAPI(api, endpointName);
    }

    @DeleteMapping("/mockserver/{endpointName}")
    private void deleteAPI(@PathVariable String endpointName){
        this.apiService.deleteAPI(endpointName);
    }
}
