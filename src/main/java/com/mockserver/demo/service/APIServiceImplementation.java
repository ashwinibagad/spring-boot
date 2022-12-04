package com.mockserver.demo.service;

import com.mockserver.demo.dao.APIDao;
import com.mockserver.demo.data.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class APIServiceImplementation implements APIService{

    @Autowired
    private APIDao apiDao;

    public APIServiceImplementation(){

    }

    @Override
    public List<API> getAPIs(){
        return apiDao.findAll(Sort.by(Sort.Direction.ASC, "httpCode"));
    }

    @Override
    public API getAPI(String endpointName){
        return apiDao.findByEndpointName(endpointName).orElseThrow(RuntimeException::new);
    }

    @Override
    public API addAPI(API api){
        apiDao.save(api);
        return api;
    }

    @Override
    public API updateAPI(API api, String endpointName){
        API persistedAPI = apiDao.findByEndpointName(endpointName).orElseGet(null);
        if(persistedAPI != null){
            persistedAPI.setHttpCode(api.getHttpCode());
            persistedAPI.setResponseBody(api.getResponseBody());

            return apiDao.save(persistedAPI);
        } else {
            throw new RuntimeException("URL not present");
        }
    }

    @Override
    public void deleteAPI(String endpointName){
        apiDao.delete(apiDao.findByEndpointName(endpointName).orElseThrow(RuntimeException::new));
    }
}
