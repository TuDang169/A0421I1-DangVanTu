import {Component, Input, OnDestroy, OnInit} from '@angular/core';

@Component({
  selector: 'app-countdown-time',
  templateUrl: './countdown-time.component.html',
  styleUrls: ['./countdown-time.component.css']
})
export class CountdownTimeComponent implements OnInit, OnDestroy {

  private intervalId = 0;
  message = ' ';
  remainingTime: number;

  @Input() seconds = 50;

  constructor() {
  }

  ngOnInit() {
    this.countDown();
  }

  private countDown() {
    let interval = setInterval(() => {
      this.seconds = --this.seconds;
      if (this.seconds === 0) {
        clearInterval(interval);
      }
    }, 1000);
  }

  ngOnDestroy() {
  }

  clearTimer() {
  }

  start() {
  }

  stop() {
  }

  reset() {
  }
}
