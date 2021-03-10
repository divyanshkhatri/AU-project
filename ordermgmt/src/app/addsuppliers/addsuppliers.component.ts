import { SupplierServiceService } from './../Services/SupplierService/supplier-service.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-addsuppliers',
  templateUrl: './addsuppliers.component.html',
  styleUrls: ['./addsuppliers.component.css'],
})
export class AddsuppliersComponent implements OnInit {
  constructor(private supplierService: SupplierServiceService) {}

  ngOnInit(): void {}

  supplierForm = new FormGroup({
    supplierName: new FormControl('', [Validators.required]),
    supplierEmail: new FormControl('', [Validators.required]),
    supplierPhone: new FormControl('', [Validators.required]),
    supplierAddress: new FormControl('', [Validators.required]),
    supplierPincode: new FormControl('', [Validators.required]),
  });

  addSupplier() {
    this.supplierService.addSupplier(this.supplierForm.value);
  }
}
