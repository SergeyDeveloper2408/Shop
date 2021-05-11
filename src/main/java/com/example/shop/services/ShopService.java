package com.example.shop.services;

import com.example.shop.error.errors.CreateOrderException;
import com.example.shop.error.errors.CustomerNotFoundException;
import com.example.shop.error.errors.ProductNotFoundException;
import com.example.shop.models.dto.OrderDto;
import com.example.shop.models.entities.Customer;
import com.example.shop.models.entities.Order;
import com.example.shop.models.entities.Product;
import com.example.shop.repositories.CustomerRepository;
import com.example.shop.repositories.OrderRepository;
import com.example.shop.repositories.ProductRepository;
import com.example.shop.utils.mappers.OrderMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderMapper orderMapper;

    public OrderDto addNewOrder(Long productId, Long customerId){
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(CustomerNotFoundException::new);

        Product product = productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);

        Order newOrder = new Order();
        newOrder.setCustomer(customer);
        newOrder.setProduct(product);

        try {
            return orderMapper.orderToOrderDto(orderRepository.save(newOrder));
        } catch (Exception e){
            throw new CreateOrderException();
        }
    }


    public List<OrderDto> getAllOrdersByCustomerId(Long customerId) {
        if (!customerRepository.existsById(customerId))
            throw new CustomerNotFoundException();

        return orderMapper.ordersToOrderDtos(orderRepository.findAllByCustomerId(customerId));
    }
}