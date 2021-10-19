package com.bank.controller.dto;

public class PaymentRequestDTO {

    private Integer payment;

    public PaymentRequestDTO(Integer payment) {
        this.payment = payment;
    }

    public PaymentRequestDTO() {
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }
}
