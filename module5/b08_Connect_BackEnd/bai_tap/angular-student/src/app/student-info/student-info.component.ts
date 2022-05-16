import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {StudentService} from "../service/student.service";

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {

  student: any;

  constructor(private activatedRoute: ActivatedRoute, private studentService: StudentService) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get("id");
      this.student = studentService.findById(Number(id));
    }, error => {

    }, ()=> {

    })
  }

  ngOnInit(): void {
  }
  changeNameStudent(event: any) {
    this.student.name = event.value;
  }

}
