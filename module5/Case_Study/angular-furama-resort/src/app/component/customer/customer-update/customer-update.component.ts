import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../../service/customer.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-customer-update',
  templateUrl: './customer-update.component.html',
  styleUrls: ['./customer-update.component.css']
})
export class CustomerUpdateComponent implements OnInit {
  customer: any;
  customerForm: FormGroup;

  constructor(private activatedRoute: ActivatedRoute ,private customerService: CustomerService, private router: Router) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get("id");
      customerService.findById(Number(id)).subscribe(next => {
        this.customer = next;
        console.log(next)
        this.customerForm = new FormGroup({
          id      : new FormControl(this.customer.id,[Validators.required]),
          name    : new FormControl(this.customer.name,[Validators.required,Validators.minLength(10)]),
          birthday: new FormControl(this.customer.birthday),
          gender  : new FormControl(this.customer.gender),
          idCard  : new FormControl(this.customer.idCard),
          phone   : new FormControl(this.customer.phone),
          email   : new FormControl(this.customer.email)
        })
      });
    }, error => {

    }, ()=> {

    })
  }

  ngOnInit(): void {
  }

  updateCustomer() {
    this.customerService.updateCustomer(this.customerForm.value.id,this.customerForm.value).subscribe();
    this.router.navigate(["/customer"])
  }
}
