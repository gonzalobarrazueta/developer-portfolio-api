package com.portfolio.controllers;

import com.portfolio.models.Pages;
import com.portfolio.services.NotionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pages")
@CrossOrigin
public class NotionController {

    private NotionService notionService;

    public NotionController(NotionService notionService) {
        this.notionService = notionService;
    }

    @GetMapping("")
    public Pages getPages() {
        return this.notionService.getPagesFromDatabase();
    }
}
