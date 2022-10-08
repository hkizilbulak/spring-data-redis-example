package com.hkizilbulak.redis.service;

import com.hkizilbulak.redis.dao.ProductDao;
import com.hkizilbulak.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product saveProduct(Product product) {
        return productDao.save(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    public Product getProductById(int id) {
        return productDao.getById(id);
    }

    public void deleteProduct(int id) {
        productDao.delete(id);
    }
}
