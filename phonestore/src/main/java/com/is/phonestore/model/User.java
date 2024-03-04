package com.is.phonestore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table()
@ToString
public class User {
    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Set<Product> products;

    @OneToMany(mappedBy = "ratedUser")
    private Set<UserRating> userRatings;

    @OneToMany(mappedBy = "ratingUser")
    private Set<UserRating> usersRated;

    @OneToMany
    @JoinColumn(name = "sender_id", referencedColumnName = "user_id")
    private Set<Message> sentMessages;

    @OneToMany
    @JoinColumn(name = "receiver_id", referencedColumnName = "user_id")
    private Set<Message> receivedMessages;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "email", nullable = false, length = 60)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 10)
    private String phoneNumber;

    @Column(name = "is_admin", nullable = false)
    private Boolean isAdmin;

    @Column(name = "user_type", nullable = false)
    private Boolean userType; // 0 - Seller; 1 - Buyer

    @Column(name = "rateing", nullable = false)
    private Float rating = (float) 0;

    @Column(name = "number_ratings", nullable = false)
    private Integer numberRatings = 0;

    @Column(name = "profil_picture_url")
    private  String profilePictureUrl;

}
