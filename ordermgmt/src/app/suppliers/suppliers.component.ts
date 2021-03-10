import { AddsuppliersComponent } from './../addsuppliers/addsuppliers.component';
import { Supplier } from './../interfaces/Supplier';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';

import { HttpClient } from '@angular/common/http';
import { catchError, map, startWith, switchMap, take } from 'rxjs/operators';
import { MatSort } from '@angular/material/sort';
import { SupplierPurchasesComponent } from '../components/SupplierPurchases/supplier-purchases/supplier-purchases.component';

@Component({
  selector: 'app-suppliers',
  templateUrl: './suppliers.component.html',
  styleUrls: ['./suppliers.component.css'],
})
export class SuppliersComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'email', 'phone', 'details'];
  dataSource = new MatTableDataSource<Supplier>();
  constructor(private dialog: MatDialog, private http: HttpClient) {}

  getData(offset: number, limit: number) {
    const requestUrl = `/api/getsuppliers?limit=${limit}&offset=${offset}`;

    return this.http.get<Supplier[]>(requestUrl);
  }

  data: Supplier[] = [];

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

  displayPurchases(element: any) {
    console.log("Clicked", element);

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = false;
    dialogConfig.height = '85vh';
    dialogConfig.width = '70vw';
    dialogConfig.hasBackdrop = true;
    dialogConfig.data = {
      id: element.supplierId
    }


    this.dialog.open(SupplierPurchasesComponent, dialogConfig);
  }

  ngOnInit(): void {
    this.paginator.pageSize = 5;
    this.paginator.length = 100;
    this.getData(0, 5)
      .pipe(take(1))
      .subscribe((data) => {
        this.dataSource.data = data;
      });

    const tableLengthUrl = `/api/getsuppliers?limit=1000&offset=0`;
    this.http.get<Supplier[]>(tableLengthUrl).subscribe((data) => {
      this.paginator.length = data.length;
    })
  }

  openDialog() {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.height = '450px';
    dialogConfig.width = '400px';
    dialogConfig.hasBackdrop = true;

    this.dialog.open(AddsuppliersComponent, dialogConfig).afterClosed().subscribe(() =>{
      this.getData(0, 5)
      .pipe(take(1))
      .subscribe((data) => {
        this.dataSource.data = data;
      });

      const tableLengthUrl = `/api/getsuppliers?limit=1000&offset=0`;
      this.http.get<Supplier[]>(tableLengthUrl).subscribe((data) => {
        this.paginator.length = data.length;
      })
    });
  }
}
