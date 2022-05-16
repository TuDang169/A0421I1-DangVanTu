import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CommonModule} from "@angular/common";
import {CustomerComponent} from "./customer.component";
import {CustomerListComponent} from "./customer-list/customer-list.component";
import {CustomerCreateComponent} from "./customer-create/customer-create.component";
import {CustomerInfoComponent} from "./customer-info/customer-info.component";
import {CustomerDeleteComponent} from "./customer-delete/customer-delete.component";
import {CustomerUpdateComponent} from "./customer-update/customer-update.component";


const routesStudent: Routes = [
    {path:"customer", component: CustomerComponent,
      children: [
        {path:"", component: CustomerListComponent},
        {path:"create", component: CustomerCreateComponent},
        {path:":id",component: CustomerInfoComponent},
        {path:"delete/:id",component: CustomerDeleteComponent},
        {path:"update/:id",component: CustomerUpdateComponent}
      ]
    },
];

@NgModule({
  imports: [CommonModule,RouterModule.forChild(routesStudent)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
