package com.example.TechStore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Cart")
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID",strategy = GenerationType.UUID)
    private UUID cartUUID;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private List<Product> productList;

    @OneToOne(mappedBy = "cart",cascade = CascadeType.ALL)
    private Set<Customer> customerSet;
}
