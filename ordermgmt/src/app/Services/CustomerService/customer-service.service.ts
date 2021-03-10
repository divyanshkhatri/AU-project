import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  constructor(private http: HttpClient) { }

  addCustomer(customer : Customer){
    // console.log(customer);
    let body = customer;
    let url = "/api/createcustomer";
    this.http.post<Customer>(url,body).subscribe((data) => {
      console.log(data);
    })
  }


}

interface Customer {

  customerId: number,
  customerName: String,
  customerEmail: String,
  customerPhone: String,
  customerAddress: String,
  customerPincode: String,

}
