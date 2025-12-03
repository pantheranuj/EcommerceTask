package com.eComm.orderService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Column(name = "Order_name", nullable = false)
    private String name;
    @Column(name = "Order_price", nullable = false)
    private Double price;
    @Column(name="description", nullable = false)
    private String description;
}
