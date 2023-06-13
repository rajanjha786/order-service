package com.bookshop.orderservice.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties(prefix = "bookshop")
public record ClientProperties(

        /*
        URI for catalog service
         */
        @NotNull
        URI catalogServiceUri
) {}
