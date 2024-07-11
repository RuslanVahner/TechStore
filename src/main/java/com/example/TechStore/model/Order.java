package com.example.TechStore.model;

import com.example.TechStore.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID",strategy = GenerationType.UUID)
    private UUID idOrder;

    @CreationTimestamp
    private LocalDateTime orderData;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "Order", cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(idOrder, order.idOrder) &&
                Objects.equals(orderData, order.orderData)
                && orderStatus == order.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, orderData, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", customer=" + customer +
                ", orderData=" + orderData +
                ", address=" + address +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
