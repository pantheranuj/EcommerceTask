package com.productsrvc.productsrvc.productController;

import com.productsrvc.productsrvc.prodEntity.Product;
import com.productsrvc.productsrvc.productService.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;
    //Create Operation
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        System.out.println(">>> Received product in controller: " + product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.createProduct(product));
    }

    //Fetch operation performed
    @GetMapping
    public ResponseEntity<Product> getById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
    }
    //update operation performed
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.update(id, product));

    }
    //Getting all
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    //delete operation performed
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
