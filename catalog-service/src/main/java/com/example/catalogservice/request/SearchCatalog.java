package com.example.catalogservice.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchCatalog {

    private static final int MAX_SIZE = 2000;
    @Builder.Default
    private Integer page = 1;
    @Builder.Default
    private Integer size = 10;

    public long getOffset(){
        return (long) (Math.max(1, page) - 1) * Math.min(size, MAX_SIZE);
    }
}
