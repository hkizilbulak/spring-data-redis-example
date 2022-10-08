package com.hkizilbulak.redis.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@RedisHash("Product")
public class Product implements Serializable {
    @Id
    private int id;
    private String name;
    private int qty;
    private BigDecimal price;
}
