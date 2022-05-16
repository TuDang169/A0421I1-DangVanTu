import { Injectable } from '@angular/core';
import {Student} from "../model/student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  studentList = [];
  constructor() {
    this.studentList.push(new Student(1,"HaiTT","10/12/1222",9));
    this.studentList.push(new Student(2,"TrungDP","11/12/1222",10));
    this.studentList.push(new Student(3,"TrungDC","09/12/1222",7));
    this.studentList.push(new Student(4,"CHienTM","07/12/1222",8));
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
