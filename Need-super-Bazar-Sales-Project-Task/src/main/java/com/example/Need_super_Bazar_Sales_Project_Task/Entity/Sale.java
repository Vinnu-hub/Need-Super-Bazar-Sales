package com.example.Need_super_Bazar_Sales_Project_Task.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int saleQuantity;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
