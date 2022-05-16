import { Component, OnInit } from '@angular/core';
import {Num} from '../num';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  num: Num = {};
  result: number;
  constructor() { }

  add(num1, num2) {
    this.result = num1 + num2;
    return this.result;
  }

  sub(num1, num2) {
    this.result = num1 - num2;
    return this.result;
  }

  multi(num1, num2) {
    this.result = num1 * num2;
    return this.result;
  }

  div(num1, num2) {
    this.result = num1 / num2;
    return this.result;
  }

  ngOnInit(): void {
  }
}
