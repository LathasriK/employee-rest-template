package com.example.employeeservice.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
    public class Uri {

        @GetMapping("/test")
        public Map<String, String> test() {

            String url = "http://localhost:8080/restService/{urlParameter}?queryParameter= {queryParameter}";

            RestTemplate template = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            HttpEntity requestEntity = new HttpEntity<>(headers);

            Map<String, String> uriVariables = new HashMap<>();

            uriVariables.put("urlParameter", "myURLParameter");
            uriVariables.put("queryParameter", "myQueryParameter");

            ResponseEntity<Map> response = template.exchange(url, HttpMethod.GET, requestEntity, Map.class, uriVariables);


            return response.getBody();
        }
    }

