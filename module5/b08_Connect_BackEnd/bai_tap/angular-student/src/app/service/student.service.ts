import { Injectable } from '@angular/core';
import {Student} from "../model/student";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  public apiURL ="http://localhost:3000/students";
  studentList = [];
  constructor(private http: HttpClient) {
    this.studentList.push(new Student(1, "Tu", 6));
    this.studentList.push(new Student(2, "Tung", 8));
    this.studentList.push(new Student(3, "Dum", 9));
    this.studentList.push(new Student(4, "Dat", 7));
  }

  createStudent(value:Student): Observable<any> {
    return this.http.post<any>(this.apiURL,value);
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
