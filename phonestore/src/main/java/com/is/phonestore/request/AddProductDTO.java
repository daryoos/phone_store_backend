package com.is.phonestore.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddProductDTO {

    private Long userId;

    private String brand;

    private String model;

    private Integer price;

    private String condition;

    private String description;

    private String location;

    private Boolean sold = false;

}
