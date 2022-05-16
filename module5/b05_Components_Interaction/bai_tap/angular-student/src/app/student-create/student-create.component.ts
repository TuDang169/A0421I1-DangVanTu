import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from "../model/student";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  student: Student = new Student(6, "voldermort", 0);

  @Output() submitCreate = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  createStudent(){
    this.submitCreate.emit(this.student);
    this.student = new Student(6, "voldermort", 0);
  }

}
