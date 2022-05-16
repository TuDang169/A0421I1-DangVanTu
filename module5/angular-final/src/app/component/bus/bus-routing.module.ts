import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CommonModule} from '@angular/common';
import {BusComponent} from './bus.component';
import {ListComponent} from './list/list.component';
import {CreateComponent} from './create/create.component';
import {InfoComponent} from './info/info.component';
import {DeleteComponent} from './delete/delete.component';
import {UpdateComponent} from './update/update.component';


const routesCustomer: Routes = [
    {path: 'bus', component: BusComponent,
      children: [
        {path: '', component: ListComponent},
        {path: 'create', component: CreateComponent},
        {path: ':id', component: InfoComponent},
        {path: 'delete/:id', component: DeleteComponent},
        {path: 'update/:id', component: UpdateComponent}
      ]
    },
];

@NgModule({
  imports: [CommonModule, RouterModule.forChild(routesCustomer)],
  exports: [RouterModule]
})
export class BusRoutingModule { }
