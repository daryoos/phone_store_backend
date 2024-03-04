package com.is.phonestore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_rating")
@ToString
public class UserRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_rating_id")
    private Long userRatingId;

    @Column(name = "rating", nullable = false)
    private Integer rating;
    @Column(name = "review", nullable = false, length = 250)
    private String review;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rated_user_id", nullable = false)
    private User ratedUser; // cine primeste

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_user_id", nullable = false)
    private User ratingUser; // cine da
}
