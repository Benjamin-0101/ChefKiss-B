package com.chefkiss.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @Column(length = 1000)
    private String description;
    
    private String address;
    private String city;
    private String cuisine;
    private String priceRange;
    private Double rating;
    private Integer reviewCount;
    private String phoneNumber;
    private String website;
    private String hours;

    @ElementCollection
    @CollectionTable(name = "restaurant_features", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "feature")
    private List<String> features;

    @ElementCollection
    @CollectionTable(name = "restaurant_images", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "image_url")
    private List<String> images;
}