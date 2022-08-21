package com.nasiatech.osofmarketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class OsofMarketplaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OsofMarketplaceApplication.class, args);
    }
}
