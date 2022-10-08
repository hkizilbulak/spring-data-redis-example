package com.hkizilbulak.redis.dao;

import com.hkizilbulak.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    private final static String HASH_KEY = "Product";
    @Autowired
    private RedisTemplate redisTemplate;

    public Product save(Product product) {
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> getAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Product getById(int id) {
        Product product = (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
        return product;
    }

    public void delete(int id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
    }
}
