package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match .MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response .MockRestResponseCreators.withSuccess;

@RestClientTest(UserService.class)
@AutoConfigureWebClient(registerRestTemplate = true)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private MockRestServiceServer server;

    @Test
    void testGetAuthenticatedUser() {
        server.expect(requestTo("http://localhost:8080/users/me"))
                .andRespond(withSuccess("{\"username\": \"user\", \"id\": 1}", MediaType.APPLICATION_JSON));

        User user = userService.getAuthenticatedUserFromExternalService();

        assertEquals("user", user.getUsername());
        assertEquals(2, user.getId());

    }


}
