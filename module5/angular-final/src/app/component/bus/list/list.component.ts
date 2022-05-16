import { Component, OnInit } from '@angular/core';
import {BusService} from '../../../service/bus.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  busList = [];

  constructor(private busService: BusService, private router: Router) {
    busService.findAll().subscribe(next => {

      this.busList = next;
    });
  }

  ngOnInit(): void {
  }

  detailCustomer(bus: any) {
    this.router.navigate(['/bus', bus.id]);
  }

  deleteCustomer(bus: any) {
    if (window.confirm('Bạn có đồng ý xoá thông tin của xe khách ' + bus.id + ' không?') === true) {
      this.router.navigate(['/bus/delete', bus.id]);
      window.alert('Xoá thành công');
    }


  }

  // createCustomer(event: any) {
  //   this.customerService.createCustomer(event);
  // }
  updateCustomer(bus: any) {
    this.router.navigate(['/bus/update', bus.id]);
  }
}
