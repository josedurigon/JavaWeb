package com.example.demo.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ClientConfig {

    @Bean
    public Client client(){
        SocketConfig socket = new SocketConfig();
        return new Client(socket.socket());
    }
}
