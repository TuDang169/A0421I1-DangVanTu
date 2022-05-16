import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../../service/customer.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {

  customer: any;
  constructor(private activatedRoute: ActivatedRoute, private customerService: CustomerService, private route: Router) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get("id");
      customerService.deleteCustomer(Number(id)).subscribe(next => {
        // this.customer = next;
        this.route.navigateByUrl("/customer");
      });
    }, error => {

    }, ()=> {
    })
  }

  ngOnInit(): void {
  }

}
