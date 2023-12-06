package com.portfolio.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private String pageId;
    private String title;
    private String description;
    private String imageUrl;
    private List<TechnologyDTO> technologies;
    private String demo;
    private String github;
    private String live;
}
