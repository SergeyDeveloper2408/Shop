package com.example.shop.models.entities;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer price;
}