package com.portfolio.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pages {
    private String object;
    private List<Map<String, Object>> results;
    @JsonProperty("next_cursor")
    private int nextCursor;
    @JsonProperty("has_more")
    private boolean hasMore;
    private String type;
    @JsonProperty("page_or_database")
    private Map<String, Object> pageOrDatabase;
}
