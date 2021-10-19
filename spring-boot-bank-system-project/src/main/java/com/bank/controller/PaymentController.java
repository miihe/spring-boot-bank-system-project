package com.bank.controller;

import com.bank.controller.dto.PaymentRequestDTO;
import com.bank.controller.dto.AccountResponseDTO;
import com.bank.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PatchMapping("/{id}")
    public AccountResponseDTO payment(@PathVariable Long id, @RequestBody PaymentRequestDTO paymentRequestDTO){
        return new AccountResponseDTO(paymentService.makePayment(id, paymentRequestDTO.getPayment()));
    }
}

