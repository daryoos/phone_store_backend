package com.is.phonestore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private Long productId;
    private String brand;
    private String model;
    private Integer price;
    private String condition;
    private String description;
    private String location;
    private Boolean sold;
    private Long userId;
}
