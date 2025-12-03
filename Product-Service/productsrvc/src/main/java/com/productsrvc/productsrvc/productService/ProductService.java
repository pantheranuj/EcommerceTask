package com.productsrvc.productsrvc.productService;

import com.productsrvc.productsrvc.prodEntity.Product;
import com.productsrvc.productsrvc.productRepo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product update(Long id, Product product) {

        Product existing = getProductById(id);
        existing.setProductName(product.getProductName());
        existing.setProductPrice(product.getProductPrice());
        existing.setProductDescription(product.getProductDescription());
        return productRepository.save(existing);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
