import { AddproductsComponent } from './../addproducts/addproducts.component';
import { Product } from './../interfaces/Product';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';

import { HttpClient } from '@angular/common/http';
import { catchError, map, startWith, switchMap, take } from 'rxjs/operators';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-allproducts',
  templateUrl: './allproducts.component.html',
  styleUrls: ['./allproducts.component.css'],
})
export class AllproductsComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'sp', 'cp', 'available'];
  dataSource = new MatTableDataSource<Product>();
  constructor(private dialog: MatDialog, private http: HttpClient) {}

  getData(offset: number, limit: number) {
    const requestUrl = `/api/getproducts?limit=${limit}&offset=${offset}`;

    return this.http.get<Product[]>(requestUrl);
  }
  data: Product[] = [];

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
        this.dataSource.data = data;
      });

      const tableLengthUrl = `/api/getproducts?limit=1000&offset=0`;
      this.http.get<Product[]>(tableLengthUrl).subscribe((data) => {
        this.paginator.length = data.length;
      })
  }

  openDialog() {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.height = '600px';
    dialogConfig.width = '420px';
    dialogConfig.hasBackdrop = true;

    this.dialog.open(AddproductsComponent, dialogConfig);
  }
}
