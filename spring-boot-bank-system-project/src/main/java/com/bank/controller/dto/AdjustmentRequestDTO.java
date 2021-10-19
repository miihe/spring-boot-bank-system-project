package com.bank.controller.dto;

public class AdjustmentRequestDTO {

    private Integer adjustment;

    public AdjustmentRequestDTO(Integer adjustment) {
        this.adjustment = adjustment;
    }

    public AdjustmentRequestDTO() {
    }

    public Integer getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Integer adjustment) {
        this.adjustment = adjustment;
    }
}
