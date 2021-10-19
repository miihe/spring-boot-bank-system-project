package com.bank.controller.dto;

import com.bank.entity.Bill;
import com.bank.entity.Account;


public class AccountResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Bill bill;

    public AccountResponseDTO(Long id, String firstName, String lastName, Integer age, Bill bill) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bill = bill;
    }

    public AccountResponseDTO(Account account) {
        id = account.getId();
        firstName = account.getFirstName();
        lastName = account.getLastName();
        age = account.getAge();
        bill = account.getBill();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
