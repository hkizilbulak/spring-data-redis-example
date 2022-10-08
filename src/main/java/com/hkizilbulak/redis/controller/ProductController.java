package com.hkizilbulak.redis.controller;

import com.hkizilbulak.redis.entity.Product;
import com.hkizilbulak.redis.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@Api(value = "API's for Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Save product", notes = "Save product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return saved product"),
            @ApiResponse(code = 400, message = "Missing or invalid request body"),
            @ApiResponse(code = 500, message = "Internal error")})
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
    }


}
