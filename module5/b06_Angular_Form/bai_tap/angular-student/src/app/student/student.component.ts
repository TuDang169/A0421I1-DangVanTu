import { Component, OnInit } from '@angular/core';
import {Student} from "../model/student";
import {StudentService} from "../service/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  studentList= [];
  student: Student;

  constructor(private studentService: StudentService,private router: Router){
    this.studentList = studentService.findAll();
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
