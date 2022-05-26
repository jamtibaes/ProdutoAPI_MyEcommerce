package com.letscode.ecommerce.produtoapi.service;

import com.letscode.ecommerce.produtoapi.enuns.OperationQuantity;
import com.letscode.ecommerce.produtoapi.dto.request.UpdateQuantityRequest;
import com.letscode.ecommerce.produtoapi.dto.response.MessageResponse;
import com.letscode.ecommerce.produtoapi.entity.ProductEntity;
import com.letscode.ecommerce.produtoapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> listAll() {
        return productRepository.findAll();
    }

    public ProductEntity findById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (productEntity.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        return productEntity.get();

    }

    public MessageResponse save(ProductEntity product) {
        productRepository.save(product);
        return MessageResponse.builder()
                .message("Product saved successfully!")
                .build();
    }

    public MessageResponse updateProduct(Long id, ProductEntity product) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (productEntity.isPresent()) {
            productEntity.get().setName(product.getName());
            productEntity.get().setDescription(product.getDescription());
            productEntity.get().setPrice(product.getPrice());
            productEntity.get().setCategory(product.getCategory());
            productEntity.get().setImage(product.getImage());
            productEntity.get().setAmount(product.getAmount());
            productRepository.save(productEntity.get());
            return MessageResponse
                    .builder()
                    .message("Product successfully updated!")
                    .build();
        }
        return MessageResponse
                .builder()
                .message("Product not updated!")
                .build();
    }

    public MessageResponse updateProductAmount(Long id, UpdateQuantityRequest quantity) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (productEntity.isPresent()) {
            ProductEntity product = productEntity.get();

            if (quantity.getOperation() == OperationQuantity.ADD) {
                product.setAmount(product.getAmount() + quantity.getAmount());
            } else {
                product.setAmount(product.getAmount() - quantity.getAmount());
            }

            productRepository.save(product);
            return MessageResponse.builder()
                    .message("Quantity successfully updated!")
                    .build();
        }
        return MessageResponse.builder()
                .message("Quantity not updated!")
                .build();
    }

    public MessageResponse delete(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isPresent()) {
            productRepository.delete(product.get());
            return MessageResponse
                    .builder()
                    .message("Product removed successfully!")
                    .build();
        }
        return MessageResponse
                .builder()
                .message("Product not found!")
                .build();
    }


}
