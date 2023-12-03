package com.example.demo.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.Socket;

@Configuration
public class SocketConfig {

    @Bean
    public Socket socket() {
        try {
            return new Socket("localhost", 8088);  // Adjust the host and port accordingly

        } catch (IOException e) {
            throw new RuntimeException("Error creating Socket bean", e);
        }
    }
}
