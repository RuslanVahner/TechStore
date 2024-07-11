package com.example.TechStore.model;

import com.example.TechStore.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Payment")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    private UUID idPayment;

    @Column(name = "Amount")
    private BigDecimal amount;

    @Column(name = "Payment_Method")
    private String paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @Column(name = "Payment_Data")
    @CreationTimestamp
    private LocalDateTime paymentData;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(idPayment, payment.idPayment) &&
                Objects.equals(amount, payment.amount) &&
                Objects.equals(paymentMethod, payment.paymentMethod) &&
                Objects.equals(order, payment.order) &&
                Objects.equals(paymentData, payment.paymentData) &&
                paymentStatus == payment.paymentStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPayment, amount, paymentMethod, order, paymentData, paymentStatus);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "idPayment=" + idPayment +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", order=" + order +
                ", paymentData=" + paymentData +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
