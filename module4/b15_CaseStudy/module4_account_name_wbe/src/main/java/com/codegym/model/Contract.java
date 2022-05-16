package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
public class Contract {

    @Id
    @Column(name = "contract_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    @Column(name = "contract_start_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent
    protected Date startDay;

    @Column(name = "contract_end_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent
    protected Date endDay;

    @Column(name = "contract_deposit")
    @NotBlank(message = "Deposit must not be Blank")
    protected double deposit;

    @Column(name = "contract_total_money")
    @NotBlank(message = "Total Money must not be Blank")
    protected double totalMoney;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    protected Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    protected Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id")
    protected Service service;

    @OneToMany(targetEntity = ContractDetail.class)
    protected List<ContractDetail> contractDetails;

    public Contract() {
    }

    public Contract(int id, @FutureOrPresent Date startDay, @FutureOrPresent Date endDay, @NotBlank(message = "Deposit must not be Blank") double deposit, @NotBlank(message = "Total Money must not be Blank") double totalMoney, Employee employee, Customer customer, Service service, List<ContractDetail> contractDetails) {
        this.id = id;
        this.startDay = startDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.contractDetails = contractDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
