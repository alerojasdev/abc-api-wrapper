package com.ale.abcapiimplementation.entity;

import jakarta.persistence.*;

@Entity
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeAccess;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(String codeAccess) {
        this.codeAccess = codeAccess;
    }
}
