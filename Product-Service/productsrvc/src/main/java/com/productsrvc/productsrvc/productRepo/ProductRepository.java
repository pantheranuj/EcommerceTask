package com.productsrvc.productsrvc.productRepo;

import com.productsrvc.productsrvc.prodEntity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
