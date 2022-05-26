package com.letscode.ecommerce.produtoapi.repository;

import com.letscode.ecommerce.produtoapi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


}
