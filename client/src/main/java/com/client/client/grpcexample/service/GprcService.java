package com.client.client.grpcexample.service;

import com.server.grpcexample.PostRequest;
import com.server.grpcexample.PostResponse;
import com.server.grpcexample.PostServiceGrpc;
import org.springframework.stereotype.Service;

@Service
public class GprcService {

    private final PostServiceGrpc.PostServiceBlockingStub postServiceBlockingStub;

    public GprcService(PostServiceGrpc.PostServiceBlockingStub postServiceBlockingStub) {
        this.postServiceBlockingStub = postServiceBlockingStub;
    }


    public String post(String name) {
        // Prepare gRPC request
        PostRequest request = PostRequest.newBuilder()
                .setName(name)
                .build();

        // Make the gRPC call
        PostResponse response = postServiceBlockingStub.post(request);

        return response.getMessage();
    }

}
