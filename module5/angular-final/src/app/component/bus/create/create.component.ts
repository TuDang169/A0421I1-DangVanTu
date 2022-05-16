import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {BusService} from '../../../service/bus.service';

@Component({
  selector: 'app-customer-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  customerForm: FormGroup;

  constructor(private customerService: BusService, private router: Router) {
    this.customerForm = new FormGroup({
      id      : new FormControl('', [Validators.required]),
      name    : new FormControl('Name', [Validators.required, Validators.minLength(10)]),
      birthday: new FormControl(),
      gender  : new FormControl(),
      idCard  : new FormControl(),
      phone   : new FormControl(),
      email   : new FormControl()
    });
  }

  // validateCustomPoint(point: AbstractControl) {
  //   let value = point.value;
  //   if(value <=0) {
  //     return {'invalid0' : true}
  //   } else {
  //     return null;
  //   }
  // }

  ngOnInit(): void {
  }

  createCustomer() {
    this.customerService.createBus(this.customerForm.value).subscribe();
    this.router.navigate(['/bus']);
  }
}
