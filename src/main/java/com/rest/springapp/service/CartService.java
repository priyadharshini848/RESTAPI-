package com.rest.springapp.service;

import com.rest.springapp.model.Cart;
import com.rest.springapp.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Page<Cart> getCarts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return cartRepository.findAll(pageable);
    }

    public List<Cart> getCartsByUniqueAttribute(String uniqueAttribute) {
        return cartRepository.findByUniqueAttribute(uniqueAttribute);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(Long id, Cart cart) {
        if (cartRepository.existsById(id)) {
            cart.setCartID(id);
            return cartRepository.save(cart);
        }
        return null;
    }

    public boolean deleteCart(Long id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
