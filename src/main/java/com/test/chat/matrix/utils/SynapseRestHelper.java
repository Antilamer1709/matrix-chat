package com.test.chat.matrix.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.util.Objects.nonNull;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Service
@RequiredArgsConstructor
public class SynapseRestHelper {

    @Value("${synapse.server.url}")
    private String synapseServerUrl;
    private final RestTemplate restTemplate;

    public <T> T get(String accessToken, String url, Class<T> responseType) {
        return restTemplate.getForEntity(resolveUrl(url, accessToken), responseType).getBody();
    }

    public <T> void exchange(String accessToken, String url, HttpMethod httpMethod, T obj) {
        restTemplate.exchange(resolveUrl(url, accessToken), httpMethod, new HttpEntity<>(obj), String.class);
    }

    public <T> T exchange(String accessToken, String url, HttpMethod httpMethod, T obj, Class<T> responseType) {
        return restTemplate.exchange(resolveUrl(url, accessToken), httpMethod, new HttpEntity<>(obj), responseType).getBody();
    }

    private String resolveUrl(String url, String accessToken) {
        if (nonNull(accessToken)) {
            return fromHttpUrl(synapseServerUrl + url)
                    .queryParam("access_token", accessToken)
                    .toUriString();
        }
        return synapseServerUrl + url;
    }

    public SynapseRestHelper() {
        this.restTemplate = new RestTemplateBuilder().build();
    }
}