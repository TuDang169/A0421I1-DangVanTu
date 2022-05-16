import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BusComponent } from './customer.component';

describe('CustomerComponent', () => {
  let component: BusComponent;
  let fixture: ComponentFixture<BusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
