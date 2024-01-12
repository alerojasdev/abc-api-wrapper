package com.ale.abcapiimplementation.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Base64;
@Component
public class Base64Converter {

    public String imageUrlToBase64String(String url){
        RestTemplate restTemplate = new RestTemplate();
        byte[] imageBytes = restTemplate.getForObject(url, byte[].class);
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        return base64Image;
    }
}
