package com.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private NotionConfigProperties notionConfig;

    public WebClientConfig(NotionConfigProperties notionConfig) {
        this.notionConfig = notionConfig;
    }

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .baseUrl(notionConfig.getApiUrl())
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + notionConfig.getAuthToken())
                .defaultHeader("Notion-Version", notionConfig.getApiVersion());
    }
}
