import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CustomerRoutingModule} from "./customer-routing.module";
import {CustomerInfoComponent} from "./customer-info/customer-info.component";
import {CustomerListComponent} from "./customer-list/customer-list.component";
import {CustomerCreateComponent} from "./customer-create/customer-create.component";
import {CustomerComponent} from "./customer.component";
import {CustomerDeleteComponent} from "./customer-delete/customer-delete.component";
import {ReactiveFormsModule} from "@angular/forms";
import { CustomerUpdateComponent } from './customer-update/customer-update.component';


@NgModule({
  declarations: [
    CustomerInfoComponent,
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerDeleteComponent,
    CustomerComponent,
    CustomerUpdateComponent,
  ],
    imports: [
        CommonModule,
        CustomerRoutingModule,
        ReactiveFormsModule,

    ],
  providers:[]
})
export class CustomerModule { }
