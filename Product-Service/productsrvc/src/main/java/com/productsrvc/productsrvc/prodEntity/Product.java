package com.productsrvc.productsrvc.prodEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "product_name",  nullable = false, length = 50,unique = true)
    private String productName;

    @Column(name = "product_description", length = 200, nullable = false )
    private String productDescription;

    @Column(name= "product_price", nullable = false)
    private double productPrice;
}
