package com.is.phonestore.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProductDTO {
    private Integer price;

    private String condition;

    private String description;

    private String location;

    private Boolean sold;
}
