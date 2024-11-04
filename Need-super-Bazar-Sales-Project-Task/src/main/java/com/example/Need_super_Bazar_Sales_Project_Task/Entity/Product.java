package com.example.Need_super_Bazar_Sales_Project_Task.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double mrp;

    @OneToMany(mappedBy = "product")
    private List<Sale> sales;
}
