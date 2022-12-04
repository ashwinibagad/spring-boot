package com.mockserver.demo.dao;

import com.mockserver.demo.data.API;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface APIDao extends JpaRepository<API, String> {

    public Optional<API> findByEndpointName(String endpointName);
}
