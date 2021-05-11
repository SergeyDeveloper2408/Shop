package com.example.shop.models.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToMany(mappedBy="customer")
    private Set<Order> orders;
}