package com.example.TechStore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(generator = "UUID",strategy = GenerationType.UUID)
    private UUID idReview;

    private String review;

    @CreationTimestamp
    private LocalDate dateReview;

    @OneToMany
    private Product product;

    @OneToMany
    private Customer customer;
}