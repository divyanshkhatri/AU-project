import { Supplier } from './../../interfaces/Supplier';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class SupplierServiceService {
  constructor(private http: HttpClient) {}

  addSupplier(supplier: Supplier) {
    // console.log(customer);
    let body = supplier;
    let url = 'http://localhost:8080/createsupplier';
    this.http.post<Supplier>(url, body).subscribe((data) => {
      console.log(data);
    });
  }
}
