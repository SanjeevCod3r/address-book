package com.sanjeev.addressbook.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ElementCollection
    @CollectionTable(name = "contact_phone_numbers", joinColumns = @JoinColumn(name = "contact_id"))
    @Column(name = "phone_number")
    private List<String> phoneNumbers = new ArrayList<>();
}