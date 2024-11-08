package com.example.tabletask.service;

import com.example.tabletask.dto.NeedSuperBazarSalesDTO;
import com.example.tabletask.entity.Product;
import com.example.tabletask.entity.Sale;
import com.example.tabletask.entity.Store;
import com.example.tabletask.repo.ProductRepository;
import com.example.tabletask.repo.SaleRepository;
import com.example.tabletask.repo.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private StoreRepository storeRepository;

    // Method to fetch sales data by storeId
    public List<NeedSuperBazarSalesDTO> getSalesByStoreId(Long storeId) {
        // Find the store by its ID
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store with ID " + storeId + " not found"));

        // Fetch all sales for the given storeId
        List<Sale> sales = saleRepository.findByStoreId(storeId);

        // List to hold the resulting sales data
        List<NeedSuperBazarSalesDTO> result = new ArrayList<>();

        // Loop through each sale to calculate total sales data
        for (Sale sale : sales) {
            Product product = sale.getProduct();
            int saleQuantity = sale.getSaleQuantity();
            double productMrp = product.getMrp();
            double totalAmount = saleQuantity * productMrp;

            // Check if the product already exists in the result list
            boolean productExists = false;
            for (NeedSuperBazarSalesDTO dto : result) {
                if (dto.getName().equals(product.getName())) {
                    // Product found, update its quantity and total amount
                    dto.setTotalQuantity(dto.getTotalQuantity() + saleQuantity);
                    dto.setTotalAmount(dto.getTotalAmount() + totalAmount);
                    productExists = true;
                    break;
                }
            }

            // If the product doesn't exist in the result list, add it as a new entry
            if (!productExists) {
                result.add(new NeedSuperBazarSalesDTO(
                        product.getName(),
                        saleQuantity,
                        productMrp,
                        totalAmount
                ));
            }
        }

        return result;
    }
}
