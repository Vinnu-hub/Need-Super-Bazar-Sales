package com.example.Need_super_Bazar_Sales_Project_Task.Repository;

import com.example.Need_super_Bazar_Sales_Project_Task.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByName(String name);
}
