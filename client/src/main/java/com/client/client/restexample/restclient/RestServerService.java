package com.client.client.restexample.restclient;

import com.client.client.restexample.restclient.model.PostRequest;
import com.client.client.restexample.restclient.model.PostResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;


public interface RestServerService {

    @PostExchange("/test-rest")
    ResponseEntity<PostResponse> findTest(@RequestBody PostRequest request);
}
