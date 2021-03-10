import { CustomerOrder } from './../interfaces/CustomerOrder';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';

import { HttpClient } from '@angular/common/http';
import { take } from 'rxjs/operators';
import { MatSort } from '@angular/material/sort';
@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css'],
})
export class OrdersComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'email'];
  dataSource = new MatTableDataSource<CustomerOrder>();
  constructor(private dialog: MatDialog, private http: HttpClient) {}

  getData(offset: number, limit: number) {
    const requestUrl = `http://localhost:8080/getorders?limit=${limit}&offset=${offset}`;

    return this.http.get<CustomerOrder[]>(requestUrl);
  }

  data: CustomerOrder[] = [];

  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;

  @ViewChild(MatPaginator, { static: true })
  paginator!: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort!: MatSort;

  fetchData() {
    console.log('next page', this.paginator.pageIndex, this.paginator.pageSize);

    this.getData(
      this.paginator.pageSize * this.paginator.pageIndex,
      this.paginator.pageSize
    ).subscribe((data) => {
      this.dataSource.data = data;
    });
  }
  ngOnInit(): void {
    this.paginator.pageSize = 5;
    this.paginator.length = 100;
    this.getData(0, 5)
      .pipe(take(1))
      .subscribe((data) => {
        console.log(data);
        this.dataSource.data = data;
      });
  }
}
