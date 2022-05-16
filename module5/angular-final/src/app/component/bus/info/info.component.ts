import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {BusService} from '../../../service/bus.service';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {
  bus: any;

  constructor(private activatedRoute: ActivatedRoute, private busService: BusService) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get('id');
      busService.findById(Number(id)).subscribe(next => {
        this.bus = next;
      });
    }, error => {

    }, () => {

    });
  }

  ngOnInit(): void {
  }
}
