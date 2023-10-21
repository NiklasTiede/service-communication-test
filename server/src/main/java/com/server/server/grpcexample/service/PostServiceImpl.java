package com.server.server.grpcexample.service;

import com.server.grpcexample.PostRequest;
import com.server.grpcexample.PostResponse;
import com.server.grpcexample.PostServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class PostServiceImpl extends PostServiceGrpc.PostServiceImplBase {

    @Override
    public void post(PostRequest request, StreamObserver<PostResponse> responseObserver) {

        // Extract the name from the request
        String name = request.getName();

        System.out.println(name);

        // Here you would typically perform some business logic.
        // For this example, let's simply respond with a message.
        String message = "Hello, " + name + "!";

        // Build the response
        PostResponse response = PostResponse.newBuilder()
                .setMessage(message)
                .build();

        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
