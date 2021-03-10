import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCustomerProductComponent } from './add-customer-product.component';

describe('AddCustomerProductComponent', () => {
  let component: AddCustomerProductComponent;
  let fixture: ComponentFixture<AddCustomerProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCustomerProductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCustomerProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
