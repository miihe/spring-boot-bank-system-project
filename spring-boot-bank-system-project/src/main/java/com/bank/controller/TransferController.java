package com.bank.controller;

import com.bank.controller.dto.TransferRequestDTO;
import com.bank.controller.dto.TransferResponseDTO;
import com.bank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PatchMapping("/transfers")
    public TransferResponseDTO transfer(@RequestBody TransferRequestDTO transferRequestDTO) {
        return new TransferResponseDTO(transferService.makeTransfer(transferRequestDTO.getSenderId(),
                transferRequestDTO.getPayeeId(), transferRequestDTO.getTransferSum()));
    }
}
