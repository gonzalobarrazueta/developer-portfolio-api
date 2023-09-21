package com.portfolio.services;

import com.portfolio.config.NotionConfigProperties;
import com.portfolio.models.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class NotionService {

    private final WebClient webClient;
    private NotionConfigProperties notionConfigProperties;

    @Autowired
    public NotionService(WebClient.Builder webClientBuilder, NotionConfigProperties notionConfig) {
        this.notionConfigProperties = notionConfig;
        this.webClient = webClientBuilder.build();
    }

    public Mono<String> getDatabaseById() {
        return webClient
                .get()
                .uri("v1/databases/" + notionConfigProperties.getDatabaseId())
                .retrieve()
                .bodyToMono(String.class);
    }

    public Pages getPagesFromDatabase() {
        return webClient
                .post()
                .uri("v1/databases/" + notionConfigProperties.getDatabaseId() + "/query")
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .bodyValue("")
                .retrieve()
                .bodyToMono(Pages.class)
                .block();
    }
}
