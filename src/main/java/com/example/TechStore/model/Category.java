package com.example.TechStore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID", strategy = GenerationType.UUID)
    private UUID categoryUUID;

    @Column(name = "title_Category")
    private String tileCategory;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> productSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryUUID, category.categoryUUID) &&
                Objects.equals(tileCategory, category.tileCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryUUID, tileCategory);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryUUID=" + categoryUUID +
                ", tileCategory='" + tileCategory + '\'' +
                ", productsSet=" + productSet +
                '}';
    }
}
