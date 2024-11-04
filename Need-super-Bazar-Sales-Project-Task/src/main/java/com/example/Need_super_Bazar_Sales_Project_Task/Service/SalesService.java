package com.example.Need_super_Bazar_Sales_Project_Task.Service;

import com.example.Need_super_Bazar_Sales_Project_Task.Entity.Product;
import com.example.Need_super_Bazar_Sales_Project_Task.Entity.Sale;
import com.example.Need_super_Bazar_Sales_Project_Task.Entity.Store;
import com.example.Need_super_Bazar_Sales_Project_Task.Repository.ProductRepository;
import com.example.Need_super_Bazar_Sales_Project_Task.Repository.SaleRepository;
import com.example.Need_super_Bazar_Sales_Project_Task.Repository.StoreRepository;
import com.example.Need_super_Bazar_Sales_Project_Task.dto.NeedSuperBazarSalesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SalesService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private SaleRepository saleRepository;

    public List<NeedSuperBazarSalesDTO> getSalesByStoreName(String storeName) {
        Store store = storeRepository.findByName(storeName)
                .orElseThrow(() -> new RuntimeException(storeName + " store not found"));

        List<Product> products = productRepository.findAll();
        List<Sale> sales = saleRepository.findByStoreId(store.getId());

        Map<Long, Integer> productSalesMap = new HashMap<>();

        // Iterate sales to sum quantities
        for (Sale sale : sales) {
            productSalesMap.merge(sale.getProduct().getId(), sale.getSaleQuantity(), Integer::sum);
        }

        List<NeedSuperBazarSalesDTO> result = new ArrayList<>();

        // Prepare the DTO list
        for (Product product : products) {
            int totalQuantity = productSalesMap.getOrDefault(product.getId(), 0);
            if (totalQuantity > 0) {
                double totalAmount = totalQuantity * product.getMrp();
                result.add(new NeedSuperBazarSalesDTO(product.getName(), totalQuantity, product.getMrp(), totalAmount));
            }
        }

        return result;
    }
}

