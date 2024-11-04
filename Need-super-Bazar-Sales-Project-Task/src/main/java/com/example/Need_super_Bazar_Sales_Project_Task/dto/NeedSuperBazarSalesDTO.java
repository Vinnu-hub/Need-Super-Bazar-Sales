package com.example.Need_super_Bazar_Sales_Project_Task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NeedSuperBazarSalesDTO {
    private String productName;
    private int saleQuantity;
    private double mrp;
    private double totalAmount;
}
