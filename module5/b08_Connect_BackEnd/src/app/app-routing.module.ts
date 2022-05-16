import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentListComponent} from "./student-list/student-list.component";
import {StudentCreateComponent} from "./student-create/student-create.component";
import {StudentInfoComponent} from "./student-info/student-info.component";

const routes: Routes = [
  {path:"", component: StudentListComponent},
  {path:"student/create", component: StudentCreateComponent},
  {path:"student/:id",component: StudentInfoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
