package com.bank.controller;

import com.bank.controller.dto.AccountResponseDTO;
import com.bank.controller.dto.AdjustmentRequestDTO;
import com.bank.service.AdjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adjustments")
public class AdjustmentController {

    private final AdjustmentService adjustmentService;

    @Autowired
    public AdjustmentController(AdjustmentService adjustmentService) {
        this.adjustmentService = adjustmentService;
    }

    @PatchMapping("/{id}")
    public AccountResponseDTO adjustment(@PathVariable Long id, @RequestBody AdjustmentRequestDTO adjustmentRequestDTO) {
        return new AccountResponseDTO(adjustmentService.makeAdjustment(id, adjustmentRequestDTO.getAdjustment()));
    }
}
