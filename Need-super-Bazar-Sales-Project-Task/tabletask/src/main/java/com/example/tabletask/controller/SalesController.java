package com.example.tabletask.controller;

import com.example.tabletask.dto.NeedSuperBazarSalesDTO;
import com.example.tabletask.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesController
{

    @Autowired
    private SalesService salesService;

    // Endpoint to get sales data by storeId
    @GetMapping("/sales/{storeId}")
    public List<NeedSuperBazarSalesDTO> getSalesByStoreId(@PathVariable Long storeId) {
        return salesService.getSalesByStoreId(storeId);
    }
}
