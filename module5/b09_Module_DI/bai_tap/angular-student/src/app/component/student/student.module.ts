import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StudentInfoComponent} from "./student-info/student-info.component";
import {StudentListComponent} from "./student-list/student-list.component";
import {StudentCreateComponent} from "./student-create/student-create.component";
import { StudentComponent } from './student.component';
import {StudentRoutingModule} from "./student-routing.module";


@NgModule({
  declarations: [
    StudentInfoComponent,
    StudentListComponent,
    StudentCreateComponent,
    StudentComponent,

  ],
  imports: [
    CommonModule,
    StudentRoutingModule
  ],
  providers:[]
})
export class StudentModule { }
