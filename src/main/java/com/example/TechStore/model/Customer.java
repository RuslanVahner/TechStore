package com.example.TechStore.model;

import com.example.TechStore.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID", strategy = GenerationType.UUID)
    private UUID idCustomer;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Create_Customer")
    @CreationTimestamp
    private LocalDateTime createCustomer;

    @Column(name = "Update_Customer")
    @UpdateTimestamp
    private LocalDateTime updateCustomer;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "Customer", cascade = CascadeType.ALL)
    private Set<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(idCustomer, customer.idCustomer)
                && Objects.equals(phone, customer.phone)
                && Objects.equals(email, customer.email)
                && Objects.equals(password, customer.password)
                && Objects.equals(firstName, customer.firstName)
                && Objects.equals(lastName, customer.lastName)
                && Objects.equals(createCustomer, customer.createCustomer)
                && Objects.equals(updateCustomer, customer.updateCustomer)
                && role == customer.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCustomer, phone, email, password, firstName, lastName, createCustomer, updateCustomer, role);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createCustomer=" + createCustomer +
                ", updateCustomer=" + updateCustomer +
                ", role=" + role +
                ", orders=" + orders +
                '}';
    }
}