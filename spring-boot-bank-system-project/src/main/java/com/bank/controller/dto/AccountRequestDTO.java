package com.bank.controller.dto;

import com.bank.entity.Bill;

public class AccountRequestDTO {

    private String firstName;
    private String lastName;
    private Integer age;
    private Bill bill;

    public AccountRequestDTO(String firstName, String lastName, Integer age, Bill bill) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bill = bill;
    }

    public AccountRequestDTO() {
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
