import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { AddcustomersComponent } from 'src/app/addcustomers/addcustomers.component';
import { AddproductsComponent } from 'src/app/addproducts/addproducts.component';
import { AddCustomerProductComponent } from '../../add-customer-product/add-customer-product.component';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialog: MatDialog, private http: HttpClient) { }

  displayedColumns: string[] = ['orderId', 'productId', 'productQuantity'];

  @ViewChild(MatPaginator, { static: true })
  paginator!: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort!: MatSort;

  dataSource = new MatTableDataSource<Product>();

  ngOnInit(): void {

    this.http.get<Product[]>(`/api/getproducts/${this.data.id}`).subscribe((data) => {
        this.dataSource.data = data;
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
    })

  }

  openDialog() {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = false;
    dialogConfig.height = '600px';
    dialogConfig.width = '450px';
    dialogConfig.hasBackdrop = true;
    dialogConfig.data = {
      orderId: this.data.id
    }


    this.dialog.open(AddCustomerProductComponent, dialogConfig).afterClosed().subscribe(() => {
      console.log("fdklfkd");
      const requestUrl =
        `/api/getcustomers?limit=5&offset=0`;

      this.http.get<Product[]>(`/api/getproducts/${this.data.id}`).subscribe((data) => {
        this.dataSource.data = data;
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      })
    });

  }

}

export interface Product{

  productId: String,
  orderId: String,
  productQuantity: number,

}
