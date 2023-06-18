package com.bookshop.orderservice.domain.order.event;

public record OrderDispatchedMessage(
        Long orderId
) {
}
