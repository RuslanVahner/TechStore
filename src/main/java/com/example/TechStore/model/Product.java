package com.example.TechStore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID", strategy = GenerationType.UUID)
    private UUID productUUID;

    @Column(name = "Product_Name")
    private String productName;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Stock_Quantity")
    private int stockQuantity;

    @Column(name = "Description")
    private String description;

    @Column(name = "Create_Product")
    @CreationTimestamp
    private LocalDateTime creatProduct;

    @Column(name = "Update_Product")
    @UpdateTimestamp
    private LocalDateTime updateProduct;

    @OneToMany(mappedBy = "Product",cascade = CascadeType.ALL)
    private Set<Review>reviews;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return stockQuantity == product.stockQuantity &&
                Objects.equals(productUUID, product.productUUID) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(price, product.price) &&
                Objects.equals(description, product.description) &&
                Objects.equals(creatProduct, product.creatProduct) &&
                Objects.equals(updateProduct, product.updateProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productUUID, productName, price, stockQuantity, description, creatProduct, updateProduct);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productUUID=" + productUUID +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", description='" + description + '\'' +
                ", creatProduct=" + creatProduct +
                ", updateProduct=" + updateProduct +
                ", reviews=" + reviews +
                ", category=" + category +
                '}';
    }
}