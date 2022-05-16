import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {BusService} from '../../../service/bus.service';
import {ActivatedRoute, Router} from '@angular/router';
import validate = WebAssembly.validate;

@Component({
  selector: 'app-customer-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  bus: any;
  busForm: FormGroup;

  constructor(private activatedRoute: ActivatedRoute , private busService: BusService, private router: Router) {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get('id');
      busService.findById(Number(id)).subscribe(next => {
        this.bus = next;
        this.busForm = new FormGroup({
          id              : new FormControl(this.bus.id, [Validators.required]),
          type            : new FormControl(this.bus.type, [Validators.required]),
          name            : new FormControl(this.bus.name, [Validators.required, Validators.minLength(10)]),
          locationGo      : new FormControl(this.bus.locationGo, [Validators.required]),
          locationArrival : new FormControl(this.bus.locationArrival, [Validators.required]),
          phone           : new FormControl(this.bus.phone, [Validators.required]),
          email           : new FormControl(this.bus.email, [Validators.required, Validators.email]),
          timeGo          : new FormControl(this.bus.timeGo, [Validators.required]),
          timeArrival     : new FormControl(this.bus.timeArrival, [Validators.required])
        });
      });
    }, error => {

    }, () => {

    });
  }

  ngOnInit(): void {
  }

  updateBus() {
    this.busService.updateBus(this.busForm.value.id, this.busForm.value).subscribe();
    window.alert('Cập nhật thành công!!');
    this.router.navigate(['/bus']);
  }
}
