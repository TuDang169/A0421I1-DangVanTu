import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from "../model/student";
import {FormControl, FormGroup} from "@angular/forms";
import {StudentService} from "../service/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  student: Student = new Student(6, "voldermort", 0);
  studentForm: FormGroup;

  constructor(private studentService: StudentService, private router: Router) {
    this.studentForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
      point: new FormControl()
    })
  }

  ngOnInit(): void {
  }

  createStudent() {
    this.studentService.createStudent(this.studentForm.value).subscribe();
    this.router.navigate([""])
  }

}
