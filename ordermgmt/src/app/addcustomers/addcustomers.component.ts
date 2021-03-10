import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CustomerData, CustomersComponent } from '../customers/customers.component';
import { CustomerServiceService } from '../Services/CustomerService/customer-service.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-addcustomers',
  templateUrl: './addcustomers.component.html',
  styleUrls: ['./addcustomers.component.css']
})
export class AddcustomersComponent implements OnInit {

  constructor(private customerService : CustomerServiceService, private http : HttpClient) {
  }

  ngOnInit(): void {
  }

  custForm = new FormGroup({

    customerId: new FormControl('',[Validators.required]),
    customerName: new FormControl('',[Validators.required, Validators.pattern("^([a-zA-Z]{2,}\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\s?([a-zA-Z]{1,})?)")]),
    customerEmail : new FormControl('',[Validators.required]),
    customerPhone : new FormControl('',[Validators.required]),
    customerAddress : new FormControl('',[Validators.required]),
    customerPincode: new FormControl('', [Validators.required])
  });

  addCustomer() {
    this.customerService.addCustomer(this.custForm.value);
  }
}
