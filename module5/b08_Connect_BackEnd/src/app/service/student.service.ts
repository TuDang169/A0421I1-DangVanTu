import { Injectable } from '@angular/core';
import {Student} from "../model/student";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  public apiURL = "http://localhost:3000/students";
  studentList = [];
  constructor(private http: HttpClient) {
    this.studentList.push(new Student(1,"HaiTT","10/12/1222",9));
    this.studentList.push(new Student(2,"TrungDP","11/12/1222",10));
    this.studentList.push(new Student(3,"TrungDC","09/12/1222",7));
    this.studentList.push(new Student(4,"CHienTM","07/12/1222",8));
  }
  createStudent(value:Student):Observable<any> {
    return this.http.post<any>(this.apiURL,value)
  }
  findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.apiURL);
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
