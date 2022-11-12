package com.employee.EmployeeApplication.entity;

import javax.persistence.*;

@Entity
public class SalaryAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bankName;
    private int number;

    @OneToOne(mappedBy = "salaryAccount")
    private Employee employee;

    public SalaryAccount(){}

    public SalaryAccount(String bankName, int number) {
        this.bankName = bankName;
        this.number = number;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
