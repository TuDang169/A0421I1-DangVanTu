import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from "../model/student";
import {AbstractControl, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {StudentService} from "../service/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  student: Student = new Student(0, "LinhDN", "2000-12-12", 10);
  studentForm: FormGroup;

  constructor(private studentService: StudentService, private router: Router) {
    this.studentForm = new FormGroup({
      id: new FormControl("",[Validators.required]),
      name: new FormControl("HaiTT",[Validators.required,Validators.minLength(10)]),
      dateOfBirth: new FormControl(),
      point: new FormControl("", this.validateCustomPoint)
    })
  }

  validateCustomPoint(point: AbstractControl) {
    let value = point.value;
    if(value <=0) {
      return {'invalid0' : true}
    } else {
      return null;
    }
  }

  ngOnInit(): void {
  }

  // createStudent(registerForm: NgForm) {
  //   console.log(registerForm);
  //   if (registerForm.valid) {
  //     this.submitCreate.emit(registerForm.value);
  //   }
  // }
  createStudent() {
     this.studentService.createStudent(this.studentForm.value);
     this.router.navigate([""])
  }
}
