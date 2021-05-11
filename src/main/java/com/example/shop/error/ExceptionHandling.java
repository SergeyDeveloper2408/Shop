package com.example.shop.error;

import com.example.shop.error.errors.CreateOrderException;
import com.example.shop.error.errors.CustomerNotFoundException;
import com.example.shop.error.errors.ProductNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFound(CustomerNotFoundException e) {
        return new ResponseEntity<>("Customer not found!", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFound(ProductNotFoundException e) {
        return new ResponseEntity<>("Product not found!", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CreateOrderException.class)
    public ResponseEntity<Object> handleCreateOrderException(CreateOrderException e) {
        return new ResponseEntity<>("Can't create order, please check your request!", new HttpHeaders(),
                HttpStatus.BAD_REQUEST);
    }
}