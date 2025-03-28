package com.rest.springapp.service;

import com.rest.springapp.model.Payment;
import com.rest.springapp.model.User;
import com.rest.springapp.repository.PaymentRepository;
import com.rest.springapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment createPaymentForUser(Long userId, Payment payment) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        payment.setUser(user);
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment paymentDetails) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isPresent()) {
            Payment existingPayment = payment.get();
            existingPayment.setAmount(paymentDetails.getAmount());
            existingPayment.setPaymentMethod(paymentDetails.getPaymentMethod());
            return paymentRepository.save(existingPayment);
        }
        return null;
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
