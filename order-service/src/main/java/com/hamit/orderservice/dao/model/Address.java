package com.hamit.orderservice.dao.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Address {
    private String country;
    private String city;
    private String district;
    private String street;
    private String zipCode;
}
