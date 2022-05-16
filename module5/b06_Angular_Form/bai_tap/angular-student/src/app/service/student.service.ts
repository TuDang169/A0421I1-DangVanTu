import { Injectable } from '@angular/core';
import {Student} from "../model/student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  studentList = [];
  constructor() {
    this.studentList.push(new Student(1, "Tu", 6));
    this.studentList.push(new Student(2, "Tung", 8));
    this.studentList.push(new Student(3, "Dum", 9));
    this.studentList.push(new Student(4, "Dat", 7));
  }

  createStudent(value:Student) {
    this.studentList.push(value);
    console.log(this.studentList)
  }
  findAll() {
    return this.studentList;
  }

  findById(id: number) {
    for(let studentObj of this.studentList) {
      if(studentObj.id == id) {
        return studentObj;
      }
    }
    return null;
  }
}
