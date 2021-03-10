import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddsuppliersComponent } from './addsuppliers.component';

describe('AddsuppliersComponent', () => {
  let component: AddsuppliersComponent;
  let fixture: ComponentFixture<AddsuppliersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddsuppliersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddsuppliersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
