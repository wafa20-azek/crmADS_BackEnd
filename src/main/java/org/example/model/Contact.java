package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String firstName;
    private String lastName;
    @OneToOne
    private Contact  contactOwner;
    private String email;
    private String phone;
    private String company;
    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;

    @Embedded
    private Address address;


}
