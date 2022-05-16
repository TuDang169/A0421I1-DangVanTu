import {Component, OnChanges, OnDestroy, OnInit} from '@angular/core';
import {Student} from "../model/student";
import {StudentService} from "../service/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  studentList =[];
  student: Student = new Student(7,"abc","12/12/2000",9);

  constructor(private studentService: StudentService,private router: Router){
    studentService.findAll().subscribe(next => {
      this.studentList = next;
    });
 }

  ngOnInit(): void {
  }

  detailStudent(student: any) {
   this.router.navigate(["/student",student.id])
  }

  createStudent(event: any) {
    this.studentService.createStudent(event);
  }

}
