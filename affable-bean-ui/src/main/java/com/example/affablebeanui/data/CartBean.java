package com.example.affablebeanui.data;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CartBean {
    private Set<CartItem> cartItems=
            new HashSet<>();
    public void addToCart(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public int cartSize() {
        return cartItems.size();
    }

    public void clearCart() {
        cartItems.clear();
    }

    public void removeFromCart(CartItem cartItem) {
        cartItems.remove(cartItem);
    }
}
