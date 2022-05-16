import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentListComponent} from "./student-list/student-list.component";
import {StudentInfoComponent} from "./student-info/student-info.component";
import {StudentCreateComponent} from "./student-create/student-create.component";
import {CommonModule} from "@angular/common";
import {StudentComponent} from "./student.component";

const routesStudent: Routes = [
    {path:"student", component: StudentComponent, children: [
      {path:"", component: StudentListComponent},
      {path:"create", component: StudentCreateComponent},
      {path:":id",component: StudentInfoComponent}
    ]},
];

@NgModule({
  imports: [CommonModule,RouterModule.forChild(routesStudent)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
