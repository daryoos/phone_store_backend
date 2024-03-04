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
@Table(name = "product")
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "brand", nullable = false, length = 45)
    private String brand;
    @Column(name = "model", nullable = false, length = 45)
    private String model;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "product_condition", nullable = false, length = 45)
    private String productCondition;
    @Column(name = "product_description", nullable = false, length = 250)
    private String productDescription;
    @Column(name = "location", nullable = false, length = 100)
    private String location;
    @Column(name = "sold", nullable = false)
    private Boolean sold;
    @Column(name = "product_image_url")
    private String imageUrl;

    @Column(name = "user_id", nullable = false)
    private Long userId;
}
