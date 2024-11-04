package com.example.Need_super_Bazar_Sales_Project_Task.Controller;

import com.example.Need_super_Bazar_Sales_Project_Task.Service.SalesService;
import com.example.Need_super_Bazar_Sales_Project_Task.dto.NeedSuperBazarSalesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/sales")
    public List<NeedSuperBazarSalesDTO> getSalesByStoreName(@RequestParam String storeName) {
        return salesService.getSalesByStoreName(storeName);
    }
}
