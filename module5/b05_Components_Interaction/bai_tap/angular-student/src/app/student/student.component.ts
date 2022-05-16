import { Component, OnInit } from '@angular/core';
import {Student} from "../model/student";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  studentList = [];
  student: Student = new Student(7, "Tu", 9);

  constructor() {
    this.studentList.push(new Student(1, "Tu", 6));
    this.studentList.push(new Student(2, "Tung", 8));
    this.studentList.push(new Student(3, "Dum", 9));
    this.studentList.push(new Student(4, "Dat", 7));
  }

  ngOnInit(): void {
  }

  detailStudent(student: any){
    this.student = student;
  }

  createStudent(event: any){
    this.studentList.push(event);
  }

}
