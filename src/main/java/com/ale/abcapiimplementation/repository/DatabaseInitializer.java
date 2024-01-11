package com.ale.abcapiimplementation.repository;

import com.ale.abcapiimplementation.entity.ApiKey;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {
    @Autowired
    private ApiKeyRepository repository;

    @PostConstruct
    public void init() {
        ApiKey apiKeyEntity = new ApiKey();
        apiKeyEntity.setCodeAccess("ABC123");
        repository.save(apiKeyEntity);
    }
}