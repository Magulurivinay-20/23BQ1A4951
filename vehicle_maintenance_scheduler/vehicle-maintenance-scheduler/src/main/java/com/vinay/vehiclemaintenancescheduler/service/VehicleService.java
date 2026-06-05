package com.vinay.vehiclemaintenancescheduler.service;

import com.vinay.vehiclemaintenancescheduler.util.Constants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VehicleService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getDepots() {

        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization",
                "Bearer " + Constants.TOKEN);

        HttpEntity<String> entity =
                new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(
                        Constants.BASE_URL + "/depots",
                        HttpMethod.GET,
                        entity,
                        String.class
                );

        return response.getBody();
    }

    public String getVehicles() {

        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization",
                "Bearer " + Constants.TOKEN);

        HttpEntity<String> entity =
                new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(
                        Constants.BASE_URL + "/vehicles",
                        HttpMethod.GET,
                        entity,
                        String.class
                );

        return response.getBody();
    }
}