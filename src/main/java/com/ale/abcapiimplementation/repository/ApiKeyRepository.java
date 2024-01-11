package com.ale.abcapiimplementation.repository;

import com.ale.abcapiimplementation.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiKeyRepository extends JpaRepository<ApiKey, Integer> {

}
