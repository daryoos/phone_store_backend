package com.is.phonestore.repository;

import com.is.phonestore.model.UserRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRatingRepository extends CrudRepository<UserRating, Long> {

    List<UserRating> findAll();

    @Query(
            value = "SELECT * FROM user_rating u WHERE u.rated_user_id = :userRatingId",
            nativeQuery = true)
    List<UserRating> getUserRating(@Param("userRatingId") Long userRatingId);
}
