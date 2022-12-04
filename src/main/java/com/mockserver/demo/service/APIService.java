package com.mockserver.demo.service;

import com.mockserver.demo.data.API;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface APIService {

    public List<API> getAPIs();

    public API getAPI(String endpointName);

    public API addAPI(API api);

    public API updateAPI(API api, String endpointName);

    public void deleteAPI(String endpointName);
}
