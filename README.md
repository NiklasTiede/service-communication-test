
# Server-Client Communication Examples

In this project I will showcase a few service-to-service communications technologies. 
Most widespread are REST HTTP requests with a client->server direction. 
More efficient in data intensive services is gRPC. And for Real-time updates 
we use either websockets (2-way communication) or server-side events (server->client direction). 

All these are 1-to-1 communication forms. If we want to notify multiple services
(1-to-many communication) we can use events like with RabbitMQ. This also has a 
retry mechanism so no message gets lost and make the communication asynchronous.

## Spring Boot 3 REST HTTP interfaces

Here we will make a simple REST HTTP request to the server-service. We will use spring boot 3's new HTTP interface
which lets us easily declare the client:

```Java
public interface RestServerService {

    @GetExchange("/test-rest")
    ResponseEntity<Post> findTest();
}
```

To spice this example a little bit up, we will 'emulate' a php-service, so sending values in snake-case
and then deserializing properly using `@JsonCreator`. Furthermore, I like using an UNKNOWN field added as default value
to the enum to avoid serialization issues in the future if a new value was added and not communicated properly. 

## gRPC

Google Remote Procedure Call (gRPC) has 3 advantage over classical REST calls:
1. serialization of used binary format is faster than JSON
2. HTTP/2 support (which has multiplexing, header compression, binary protocol etc.) as compared to HTTP/1 in REST
3. strongly typed definitions with Protocol Buffers

So data-intensive services with big payloads are especially benefiting from this. Also, when the services
use many different languages the Protocol Buffers are very beneficial.

```Java
public interface RestServerService {

    @GetExchange("/test-rest")
    ResponseEntity<Post> findTest();
}
```




## Server-Side Events (SSE) with REST




## Server-Side Events (SSE) with gRPC



## JMS Events with RabbitMQ/Spring Cloud Stream

- RabbitMQ instance with dcoker-compsoe (and its new integration!)

