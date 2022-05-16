package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Service {
    @Id
    @Column(name = "service_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "service_name")
    @NotBlank(message = "Name must not be Blank")
    protected String name;

    @Column(name = "service_area")
    @NotBlank(message = "Area must not be Blank")
    protected int area;

    @Column(name = "service_cost")
    @NotBlank(message = "Price must not be Blank")
    protected double cost;

    @Column(name = "service_max_eople")
    @NotBlank(message = "Max People must not be Blank")
    protected int maxPeople;

    @Column(name = "service_standard_room")
    @NotBlank(message = "Standard Room must not be Blank")
    protected String standardRoom;

    @Column(name = "service_description")
    protected String description;

    @Column(name = "service_pool_area")
    @NotBlank(message = "Pool Area must not be Blank")
    protected double poolArea;

    @Column(name = "service_floors")
    @NotBlank(message = "Number of Floors must not be Blank")
    protected int floors;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    protected RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    protected ServiceType serviceType;


    @OneToMany(mappedBy = "service")
    protected List<Contract> contracts;

    public Service() {
    }

    public Service(Long id, @NotBlank(message = "Name must not be Blank") String name, @NotBlank(message = "Area must not be Blank") int area, @NotBlank(message = "Price must not be Blank") double cost, @NotBlank(message = "Max People must not be Blank") int maxPeople, @NotBlank(message = "Standard Room must not be Blank") String standardRoom, String description, @NotBlank(message = "Pool Area must not be Blank") double poolArea, @NotBlank(message = "Number of Floors must not be Blank") int floors, RentType rentType, ServiceType serviceType, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.floors = floors;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.contracts = contracts;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
