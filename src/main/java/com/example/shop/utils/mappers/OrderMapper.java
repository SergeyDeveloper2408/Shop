package com.example.shop.utils.mappers;

import com.example.shop.models.dto.OrderDto;
import com.example.shop.models.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mappings({
            @Mapping(target="productId", source="order.product.id"),
            @Mapping(target="productTitle", source="order.product.title"),
            @Mapping(target="price", source="order.product.price")
    })
    OrderDto orderToOrderDto(Order order);

    List<OrderDto> ordersToOrderDtos(List<Order> orders);

}