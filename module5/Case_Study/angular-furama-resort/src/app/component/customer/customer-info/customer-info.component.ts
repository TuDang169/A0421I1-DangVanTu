import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CustomerService} from "../../../service/customer.service";

@Component({
  selector: 'app-customer-info',
  templateUrl: './customer-info.component.html',
  styleUrls: ['./customer-info.component.css']
})
export class CustomerInfoComponent implements OnInit {
  customer: any;

  constructor(private activatedRoute: ActivatedRoute, private customerService: CustomerService) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get("id");
      customerService.findById(Number(id)).subscribe(next => {
        this.customer = next;
      });
    }, error => {

    }, ()=> {

    })
  }

  ngOnInit(): void {
  }
  changeNameCustomer(event: any) {
    this.customer.name = event.value;
  }

}
