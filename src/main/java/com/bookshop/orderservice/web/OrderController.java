package com.bookshop.orderservice.web;

import com.bookshop.orderservice.domain.order.Order;
import com.bookshop.orderservice.domain.order.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public Flux<Order> getAllOrders() {
        log.info("Getting all Orders");
        return orderService.getAllOrders();
    }

    @PostMapping
    public Mono<Order> submitOrder(
            @RequestBody @Valid OrderRequest orderRequest
    ) {
        log.info("Received order {}", orderRequest);
        return orderService.submitOrder(
                orderRequest.isbn(), orderRequest.quantity()
        );
    }
}
