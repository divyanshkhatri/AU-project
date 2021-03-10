import { Product } from './../../interfaces/Product';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ProductServiceService {
  constructor(private http: HttpClient) {}

  addProduct(product: Product) {
    // console.log(customer);
    let body = product;
    let url = 'http://localhost:8080/createproduct';
    this.http.post<Product>(url, body).subscribe((data) => {
      console.log(data);
    });
  }

  createOrderProduct(customerorderproduct: any, id: number) {

    customerorderproduct.orderId = id;
    let body = customerorderproduct;
    let url = 'http://localhost:8080/createorderproduct';
    this.http.post<Product>(url, body).subscribe((data) => {
      console.log(data);
    });

  }
}

export interface Customerorderproduct {

  orderId: number,
  productQuantity: number,
  productId: number

}
