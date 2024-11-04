package com.example.Need_super_Bazar_Sales_Project_Task.Repository;

import com.example.Need_super_Bazar_Sales_Project_Task.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByStoreId(Long storeId);
}
