package com.example.shop.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({ "id", "productId", "productTitle", "price" })
public class OrderDto {

    private Long id;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("product_title")
    private String productTitle;

    private Integer price;
}