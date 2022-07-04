package com.dokripgiji.web.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
public class convenientController {

    private final String url ="https://dapi.kakao.com/v2/local/search/category.json";
    private final String key = "9383895f69880f4da54c9c4b280df82d";

    @GetMapping("/convenient")
    public Map callLocalApi(@RequestParam String category_group_code, @RequestParam String x, @RequestParam String y, @RequestParam int radius){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "KakaoAK "+key);
        UriComponentsBuilder builder = UriComponentsBuilder
                    .fromHttpUrl(url)
                    .queryParam("category_group_code", category_group_code).queryParam("x", x).queryParam("y", y).queryParam("radius", radius);

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Map.class).getBody();
    }

}
