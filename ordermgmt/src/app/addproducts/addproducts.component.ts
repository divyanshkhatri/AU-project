import { ProductServiceService } from './../Services/ProductService/product-service.service';
import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith,} from 'rxjs/operators';
import { Product } from '../interfaces/Product';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-addproducts',
  templateUrl: './addproducts.component.html',
  styleUrls: ['./addproducts.component.css'],
})
export class AddproductsComponent implements OnInit {
  constructor(
    private productService: ProductServiceService,
    private dialog: MatDialog,
    private http: HttpClient,
  ) {}

  options: Product[] = [];
  products: String[] = [];
  ngOnInit() {

    this.getData().subscribe((data) => {
      console.log(data);
      this.options = [...data];
      console.log(this.options);
      this.options.forEach((option: Product) => {
        this.products.push(option.productName);
      });
    });


    console.log(this.products);
  }
  getData() {

      const requestUrl = `http://localhost:8080/getproducts?limit=100&offset=0`;

      return this.http.get<Product[]>(requestUrl);

  }

  productForm = new FormGroup({
    productName: new FormControl('', [Validators.required]),
    productOnHand: new FormControl('', [Validators.required]),
    productAvailable: new FormControl('', [Validators.required]),
    productOutgoing: new FormControl('', [Validators.required]),
    productIncoming: new FormControl('', [Validators.required]),
    productSellingPrice: new FormControl('', [Validators.required]),
    productcostPrice: new FormControl('', [Validators.required])
  });

  addProduct() {
      this.productService.addProduct(this.productForm.value);
  }
}
