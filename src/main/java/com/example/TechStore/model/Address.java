package com.example.TechStore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID", strategy = GenerationType.UUID)
    private UUID addressUUID;

    @Column(name = "Street_Name")
    private String streetName;

    @Column(name = "zip_Code")
    private String zipCode;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "address",cascade = CascadeType.ALL)
    private List<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressUUID, address.addressUUID) &&
                Objects.equals(streetName, address.streetName)
                && Objects.equals(zipCode, address.zipCode)
                && Objects.equals(country, address.country)
                && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressUUID, streetName, zipCode, country, city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressUUID=" + addressUUID +
                ", streetName='" + streetName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", orders=" + orders +
                '}';
    }
}