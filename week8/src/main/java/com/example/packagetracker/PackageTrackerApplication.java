package com.example.packagetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Smart Package Delivery Tracking System
 * 
 * This application provides a web-based interface for:
 * - Registering packages with tracking information
 * - Viewing all registered packages
 * - Tracking delivery status
 * 
 * @SpringBootApplication enables:
 *   - @Configuration: Marks this as a configuration class
 *   - @EnableAutoConfiguration: Enables Spring Boot's auto-configuration
 *   - @ComponentScan: Scans for components in this package and sub-packages
 */
@SpringBootApplication
public class PackageTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PackageTrackerApplication.class, args);
        
        System.out.println("\n" +
                "========================================\n" +
                "📦 Smart Package Delivery Tracking System\n" +
                "========================================\n" +
                "Application started successfully!\n" +
                "Access the application at: http://localhost:8080\n" +
                "H2 Console (if enabled): http://localhost:8080/h2-console\n" +
                "========================================\n");
    }
}
