package com.nn.study.entities;

import com.nn.study.handlers.AddressTypeHandler;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tabple_emp")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    private String empName;
    @Column(name = "emp_salary")
    private Double empSalary;

    private Integer empAge;
    @Column(name="seasonEnum")
    private SeasonEnum seasonEnum;

    //@ColumnType(typeHandler = AddressTypeHandler.class)
    @Column
    private Address address;

    public Employee() {
    }

    public Employee(String empName, Double empSalary, Integer empAge, SeasonEnum seasonEnum, Address address) {
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
        this.seasonEnum = seasonEnum;
        this.address = address;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public SeasonEnum getSeasonEnum() {
        return seasonEnum;
    }

    public void setSeasonEnum(SeasonEnum seasonEnum) {
        this.seasonEnum = seasonEnum;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empAge=" + empAge +
                ", seasonEnum=" + seasonEnum +
                ", address=" + address +
                '}';
    }
}
