package com.is.phonestore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRatingDTO {
    private String createdBy;

    private Integer rating;

    private String product;
}
