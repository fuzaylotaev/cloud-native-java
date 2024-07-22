package com.example;

import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.RequestEntity.get;

@Service("userService")
public class UserService {

    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getAuthenticatedUser() {
        return new User(1, "frank");
    }

    public User getAuthenticatedUserFromExternalService() {
        URI url = URI.create("http://localhost:8080/users/me");
        RequestEntity<Void> request = get(url).header(HttpHeaders.CONTENT_TYPE,
                APPLICATION_JSON_VALUE).build();
        return restTemplate.exchange(request, User.class).getBody();
    }
}
