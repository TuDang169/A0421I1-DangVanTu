import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {

  @Input() student: any;

  constructor() { }

  ngOnInit(): void {
  }

}
