import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../../service/customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customerList =[];

  constructor(private customerService: CustomerService,private router: Router){
    customerService.findAll().subscribe(next => {

      this.customerList = next;
    });
  }

  ngOnInit(): void {
  }

  detailCustomer(customer: any) {
    this.router.navigate(["/customer",customer.id])
  }

  deleteCustomer(customer: any) {
    this.router.navigate(["/customer/delete",customer.id])
  }

  // createCustomer(event: any) {
  //   this.customerService.createCustomer(event);
  // }
  updateCustomer(customer: any) {
    this.router.navigate(["/customer/update",customer.id])
  }
}
