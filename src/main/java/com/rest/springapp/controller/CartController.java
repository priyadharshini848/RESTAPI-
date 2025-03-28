package com.rest.springapp.controller;

import com.rest.springapp.model.Cart;
import com.rest.springapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public Page<Cart> getCarts(@RequestParam int page, @RequestParam int size) {
        return cartService.getCarts(page, size);
    }

    @GetMapping("/unique")
    public List<Cart> getCartsByUniqueAttribute(@RequestParam String uniqueAttribute) {
        return cartService.getCartsByUniqueAttribute(uniqueAttribute);
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        return cartService.updateCart(id, cart);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCart(@PathVariable Long id) {
        return cartService.deleteCart(id);
    }
}
