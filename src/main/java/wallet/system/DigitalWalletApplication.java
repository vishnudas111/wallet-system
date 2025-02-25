package wallet.system;

package com.example.digitalwallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Entry point for the Digital Wallet System application.
 */
@SpringBootApplication
@EnableCaching  // Enables Redis caching
@EnableKafka    // Enables Kafka event-driven messaging
@EnableAsync    // Enables asynchronous processing
public class DigitalWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalWalletApplication.class, args);
        System.out.println("Digital Wallet System is running on port 8080...");
    }
}
