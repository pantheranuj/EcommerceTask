package com.productsrvc.productsrvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@FeignClient(name = "product-service")
public class ProductsrvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsrvcApplication.class, args);
	}

}
