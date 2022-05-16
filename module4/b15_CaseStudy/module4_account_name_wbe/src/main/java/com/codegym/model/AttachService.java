package com.codegym.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class AttachService {
    @Id
    @Column(name = "attach_service_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "attach_service_name")
    protected String name;

    @Column(name = "attach_service_cost")
    protected double cost;

    @Column(name = "attach_service_unit")
    protected int unit;

    @Column(name = "attach_service_status")
    protected String status;

    @OneToMany(targetEntity = ContractDetail.class)
    protected List<ContractDetail> contractDetails;

    public AttachService() {
    }

    public AttachService(Long id, String name, double cost, int unit, String status, List<ContractDetail> contractDetails) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
