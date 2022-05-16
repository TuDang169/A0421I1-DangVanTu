import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentComponent} from "./student/student.component";
import {StudentCreateComponent} from "./student-create/student-create.component";
import {StudentInfoComponent} from "./student-info/student-info.component";


const routes: Routes = [
  {path:"", component: StudentComponent},
  {path:"student/create", component: StudentCreateComponent},
  {path:"student/:id",component: StudentInfoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
