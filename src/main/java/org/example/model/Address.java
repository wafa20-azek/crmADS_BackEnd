package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Address {
    private String address;
    private String city;
    private String country;
    private String state;
    private int zipCode;
}
