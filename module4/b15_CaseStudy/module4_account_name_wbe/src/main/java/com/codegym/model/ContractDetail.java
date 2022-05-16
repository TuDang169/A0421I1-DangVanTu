package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class ContractDetail {

    @Id
    @Column(name = "contract_detail_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotBlank(message = "Quantity must not be Blank")
    protected String quantity;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    protected Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id")
    protected AttachService attachService;

    public ContractDetail() {
    }

    public ContractDetail(Long id, @NotBlank(message = "Quantity must not be Blank") String quantity, Contract contract, AttachService attachService) {
        this.id = id;
        this.quantity = quantity;
        this.contract = contract;
        this.attachService = attachService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
