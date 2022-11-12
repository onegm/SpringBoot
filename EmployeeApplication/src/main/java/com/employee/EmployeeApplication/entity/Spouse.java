package com.employee.EmployeeApplication.entity;

import javax.persistence.*;

@Entity
@Table(name="spouse") // Customize table name
public class Spouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String telephone;
    private int age;

    @OneToOne(mappedBy = "spouse") // Adding bidirectional relationship
    private Employee employee;  // No new column created for spouse table.

    public Spouse(){}

    public Spouse(String name, String telephone, int age) {
        this.name = name;
        this.telephone = telephone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
