package com.server.server.restexample.controller;

import com.server.server.restexample.model.PostRequest;
import com.server.server.restexample.model.PostResponse;
import com.server.server.restexample.model.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class RestExampleController {

    @PostMapping("/test-rest")
    public ResponseEntity<PostResponse> getCurrentAccount(@RequestBody PostRequest request) {

        String message = request.message();

        byte[] byteArray = message.getBytes(StandardCharsets.UTF_8);

        // Calculate size in bytes
        int sizeInBytes = byteArray.length;

        // Convert size to kilobytes
        double sizeInKilobytes = (double) sizeInBytes / 1024;

        System.out.println("Size in bytes: " + sizeInBytes);
        System.out.println("Size in kilobytes: " + sizeInKilobytes);

        return new ResponseEntity<>(new PostResponse(message,
                "two", Status.PERSON_IN_VACATION), HttpStatus.OK);
    }
}
