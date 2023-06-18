package com.bookshop.orderservice.domain.order.event;

import com.bookshop.orderservice.domain.order.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Configuration
@Slf4j
@AllArgsConstructor
public class OrderFunction {

    private final OrderService orderService;
    @Bean
    public Consumer<Flux<OrderDispatchedMessage>> dispatchOrder() {
        return flux -> orderService.consumeOrderDispatchedEvent(flux)
                .doOnNext(order -> log.info("The order with id {} is dispatched", order.id()))
                .subscribe();
    }
}
