package com.ale.abcapiimplementation.repository;

import com.ale.abcapiimplementation.dto.ApiKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiKeyRepository extends JpaRepository<ApiKeyEntity, Integer> {

}
