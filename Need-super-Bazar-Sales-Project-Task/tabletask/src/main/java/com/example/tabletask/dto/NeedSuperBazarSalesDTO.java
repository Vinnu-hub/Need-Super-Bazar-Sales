package com.example.tabletask.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class NeedSuperBazarSalesDTO {

    private String name;
    private int totalQuantity;
    private double mrp;
    private double totalAmount;
}