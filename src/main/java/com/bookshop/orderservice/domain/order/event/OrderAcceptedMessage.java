package com.bookshop.orderservice.domain.order.event;

public record OrderAcceptedMessage(
        Long orderId
) {
}
