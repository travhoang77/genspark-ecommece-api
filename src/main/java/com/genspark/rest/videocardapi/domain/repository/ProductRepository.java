package com.genspark.rest.videocardapi.domain.repository;

import com.genspark.rest.videocardapi.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
