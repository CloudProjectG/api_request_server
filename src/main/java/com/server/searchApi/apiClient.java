package com.server.searchApi;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Service
@RequiredArgsConstructor
public class apiClient {

    @Value("${naver.client.id}")
    private String ClientId;

    @Value("${naver.client.secret}")
    private String ClientSecret;

    public SearchRes search(String query) {
        var uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", "영통" + query)
                .queryParam("display", 5)
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", ClientId);
        headers.set("X-Naver-Client-Secret", ClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchRes>(){};

        var responseEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, responseType);

        return responseEntity.getBody();
    }
}
