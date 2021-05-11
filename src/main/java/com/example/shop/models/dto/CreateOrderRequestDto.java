package com.example.shop.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderRequestDto {

    @JsonProperty("product_id")
    Long productId;

    @JsonProperty("customer_id")
    Long customerId;
}
