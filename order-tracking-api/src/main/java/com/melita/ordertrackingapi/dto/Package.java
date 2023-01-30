package com.melita.ordertrackingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Package {
    private Integer id;
    private String name;
    private String description;
    private Integer productId;
    private Double cost;
}
