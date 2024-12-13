package com.stlang.dreamshops.service.cart;

import com.stlang.dreamshops.model.Cart;
import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
    Long initializeNewCart();
}