package com.example.tabletask.repo;

import com.example.tabletask.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Long> {

     List<Sale> findByStoreId(Long storeId);
}