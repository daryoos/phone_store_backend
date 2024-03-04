package com.is.phonestore.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddUserRatingDTO {

    private String review;

    private Long userRatingId;

}
