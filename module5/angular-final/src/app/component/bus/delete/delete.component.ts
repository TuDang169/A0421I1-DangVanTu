import { Component, OnInit } from '@angular/core';
import {BusService} from '../../../service/bus.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  bus: any;
  constructor(private activatedRoute: ActivatedRoute, private busService: BusService, private route: Router) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get('id');
      busService.deleteBus(Number(id)).subscribe(next => {
        // this.bus = next;
        this.route.navigateByUrl('/bus');
      });
    }, error => {

    }, () => {
    });
  }

  ngOnInit(): void {
  }

}
