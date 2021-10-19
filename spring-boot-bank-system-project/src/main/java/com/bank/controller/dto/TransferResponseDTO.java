package com.bank.controller.dto;

import com.bank.entity.Bill;
import com.bank.entity.Account;

public class TransferResponseDTO {

    private Long idSender;
    private String firstNameSender;
    private String lastNameSender;
    private Integer ageSender;
    private Bill billSender;

    private Long idPayee;
    private String firstNamePayee;
    private String lastNamePayee;
    private Integer agePayee;
    private Bill billPayee;

    public TransferResponseDTO() {
    }

    public TransferResponseDTO(Account[] accounts) {
        idSender = accounts[0].getId();
        firstNameSender = accounts[0].getFirstName();
        lastNameSender = accounts[0].getLastName();
        ageSender = accounts[0].getAge();
        billSender = accounts[0].getBill();

        idPayee = accounts[1].getId();
        firstNamePayee = accounts[1].getFirstName();
        lastNamePayee = accounts[1].getLastName();
        agePayee = accounts[1].getAge();
        billPayee = accounts[1].getBill();
    }

    public Long getIdSender() {
        return idSender;
    }

    public void setIdSender(Long idSender) {
        this.idSender = idSender;
    }

    public String getFirstNameSender() {
        return firstNameSender;
    }

    public void setFirstNameSender(String firstNameSender) {
        this.firstNameSender = firstNameSender;
    }

    public String getLastNameSender() {
        return lastNameSender;
    }

    public void setLastNameSender(String lastNameSender) {
        this.lastNameSender = lastNameSender;
    }

    public Integer getAgeSender() {
        return ageSender;
    }

    public void setAgeSender(Integer ageSender) {
        this.ageSender = ageSender;
    }

    public Bill getBillSender() {
        return billSender;
    }

    public void setBillSender(Bill billSender) {
        this.billSender = billSender;
    }

    public Long getIdPayee() {
        return idPayee;
    }

    public void setIdPayee(Long idPayee) {
        this.idPayee = idPayee;
    }

    public String getFirstNamePayee() {
        return firstNamePayee;
    }

    public void setFirstNamePayee(String firstNamePayee) {
        this.firstNamePayee = firstNamePayee;
    }

    public String getLastNamePayee() {
        return lastNamePayee;
    }

    public void setLastNamePayee(String lastNamePayee) {
        this.lastNamePayee = lastNamePayee;
    }

    public Integer getAgePayee() {
        return agePayee;
    }

    public void setAgePayee(Integer agePayee) {
        this.agePayee = agePayee;
    }

    public Bill getBillPayee() {
        return billPayee;
    }

    public void setBillPayee(Bill billPayee) {
        this.billPayee = billPayee;
    }
}
