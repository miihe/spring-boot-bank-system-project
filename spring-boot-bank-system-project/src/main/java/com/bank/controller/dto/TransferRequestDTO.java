package com.bank.controller.dto;

public class TransferRequestDTO {

    private Long senderId;
    private Long payeeId;
    private Integer transferSum;

    public TransferRequestDTO(Long senderId, Long payeeId, Integer transferSum) {
        this.senderId = senderId;
        this.payeeId = payeeId;
        this.transferSum = transferSum;
    }

    public TransferRequestDTO() {
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
    }

    public Integer getTransferSum() {
        return transferSum;
    }

    public void setTransferSum(Integer transferSum) {
        this.transferSum = transferSum;
    }
}
