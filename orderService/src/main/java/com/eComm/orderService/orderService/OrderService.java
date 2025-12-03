package com.eComm.orderService.orderService;

import com.eComm.orderService.entity.Order;
import com.eComm.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }
    public Order getById(Integer id) {
        return orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order Not Found"));
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order update(Order order, Integer id) {
        Order existing = getById(id);
        existing.setName(order.getName());
        existing.setPrice(order.getPrice());
        existing.setDescription(order.getDescription());
        return orderRepository.save(existing);
    }

    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }



}
