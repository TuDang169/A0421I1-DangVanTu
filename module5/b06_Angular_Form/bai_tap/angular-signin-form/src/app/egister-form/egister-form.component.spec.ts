import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EgisterFormComponent } from './egister-form.component';

describe('EgisterFormComponent', () => {
  let component: EgisterFormComponent;
  let fixture: ComponentFixture<EgisterFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EgisterFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EgisterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
