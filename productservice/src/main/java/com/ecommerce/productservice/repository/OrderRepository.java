package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}