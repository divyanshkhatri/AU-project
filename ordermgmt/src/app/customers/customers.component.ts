import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import {MatDialog, MatDialogConfig, MatDialogRef, } from '@angular/material/dialog';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import { Router } from '@angular/router';
import {AddcustomersComponent} from '../addcustomers/addcustomers.component';
import { HttpClient } from '@angular/common/http';
import {merge, Observable, of as observableOf} from 'rxjs';
import {catchError, map, startWith, switchMap, take} from 'rxjs/operators';
import { MatSort } from '@angular/material/sort';
import { CustomerOrderComponent } from '../components/CustomerOrderComponent/customer-order/customer-order.component';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'email', 'phone', 'details'];
  dataSource = new MatTableDataSource<Customer>();


  // @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private router: Router, private dialog: MatDialog, private http: HttpClient) {
  }

  getRepoIssues(offset: number, limit: number) {

    const requestUrl =
        `/api/getcustomers?limit=${limit}&offset=${offset}`;

    return this.http.get<CustomerData>(requestUrl);
  }

  clicked(element: any) {
    console.log("Clicked", element);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = false;
    dialogConfig.height = '85vh';
    dialogConfig.width = '70vw';
    dialogConfig.hasBackdrop = true;
    dialogConfig.data = {
      id: element.customerId
    }


    this.dialog.open(CustomerOrderComponent, dialogConfig);

  }

  data!: CustomerData;

  headers = ["customerId", "customerName", "customerEmail", "customerPhone"];

  resultsLength = 0;

  isLoadingResults = true;

  isRateLimitReached = false;

  @ViewChild(MatPaginator, { static: true })
  paginator!: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort!: MatSort;

  fetchData() {
    console.log("next page", this.paginator.pageIndex, this.paginator.pageSize);
    // this.paginator.pageIndex = 2;
    this.getRepoIssues(this.paginator.pageSize*(this.paginator.pageIndex), this.paginator.pageSize).subscribe((data) => {
      console.log(data);
      this.dataSource.data = data.customers;
    });
  }

  ngOnInit() {
    this.paginator.pageSize = 5;

    this.getRepoIssues(0, 5).pipe(take(1)).subscribe((data) => {
      console.log(data);
      this.dataSource.data = data.customers;
      this.paginator.length = data.totalCustomers;
    });

    // this.dataSource.paginator = this.paginator;
    // this.dataSource.sort = this.sort;

  }

  openDialog() {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.height = '500px';
    dialogConfig.width = '400px';
    dialogConfig.hasBackdrop = true;

    this.dialog.open(AddcustomersComponent, dialogConfig);

    this.dialog.afterAllClosed.subscribe((data) => {
      console.log("fdklfkd");
      const requestUrl =
        `/api/getcustomers?limit=5&offset=0`;

      this.http.get<CustomerData>(requestUrl).subscribe((data) => {
        this.dataSource.data = data.customers;
        this.paginator.length = data.totalCustomers;
      })
    });
  }
}


export interface Customer {

  customerId: number,
  customerName: String,
  customerEmail: String,
  customerPhone: String,
  customerAddress: String,
  customerPincode: String,

}

export interface CustomerData {
  customers: Customer[],
  totalCustomers: number
}
