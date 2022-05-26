package com.letscode.ecommerce.produtoapi.controller;

import com.letscode.ecommerce.produtoapi.dto.request.UpdateQuantityRequest;
import com.letscode.ecommerce.produtoapi.dto.response.MessageResponse;
import com.letscode.ecommerce.produtoapi.entity.ProductEntity;
import com.letscode.ecommerce.produtoapi.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> listAll() {
        List<ProductEntity> products = productService.listAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductEntity> findById(@PathVariable Long id) {
        ProductEntity productEntity = productService.findById(id);
        return ResponseEntity.ok(productEntity);
    }

    @PostMapping("/product")
    public MessageResponse save(@RequestBody ProductEntity product) {
        return productService.save(product);
    }

    @PutMapping("/product/{id}")
    public MessageResponse updateProduct(@PathVariable Long id, @RequestBody ProductEntity product) {
        return productService.updateProduct(id, product);
    }

    @PatchMapping("/product/{id}")
    public MessageResponse updateProductAmount(@PathVariable Long id, @RequestBody UpdateQuantityRequest update) {
        return productService.updateProductAmount(id, update);
    }

    @DeleteMapping("/product/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return productService.delete(id);
    }

}
