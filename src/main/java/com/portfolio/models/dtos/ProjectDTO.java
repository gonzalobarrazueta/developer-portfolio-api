package com.portfolio.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private Integer pageId;
    private String title;
    private String description;
    private String imageUrl;
}
