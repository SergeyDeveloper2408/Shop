package com.example.shop.controllers;

import com.example.shop.models.dto.CreateOrderRequestDto;
import com.example.shop.models.dto.OrderDto;
import com.example.shop.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShopController {

    @Autowired
    ShopService shopService;

    @PostMapping("/orders/add")
    public ResponseEntity<Object> addNewOrder(@RequestBody CreateOrderRequestDto request){
        return ResponseEntity.ok(shopService.addNewOrder(request.getProductId(), request.getCustomerId()));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getAllOrders(@RequestParam("customerId") Long customerId){
        return ResponseEntity.ok(shopService.getAllOrdersByCustomerId(customerId));
    }
}