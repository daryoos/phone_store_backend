package com.is.phonestore.controller;

import com.is.phonestore.dto.UserRatingDTO;
import com.is.phonestore.request.AddUserRatingDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/v1/userRatings")
public interface UserRatingControllerResource {
    @GetMapping(value = "/getUserRatingById/{id}")
    ResponseEntity<List<UserRatingDTO>> getUserRatingById(@PathVariable Long id);

}
