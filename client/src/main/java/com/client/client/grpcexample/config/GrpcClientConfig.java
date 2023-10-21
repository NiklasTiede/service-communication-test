package com.client.client.grpcexample.config;

import com.server.grpcexample.PostServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();
    }

    @Bean
    public PostServiceGrpc.PostServiceBlockingStub postServiceBlockingStub(ManagedChannel managedChannel) {
        return PostServiceGrpc.newBlockingStub(managedChannel);
    }

}
