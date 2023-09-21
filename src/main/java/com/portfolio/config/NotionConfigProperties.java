package com.portfolio.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "notion")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotionConfigProperties {
    private String apiUrl;
    private String apiVersion;
    private String databaseId;
    private String authToken;
}

