package com.example.affablebeanui.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItem {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public CartItem() {

    }
}
