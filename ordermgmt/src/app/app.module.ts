import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { BrowserModule } from '@angular/platform-browser';
import { MatIconModule } from '@angular/material/icon';
import { NgModule, Component } from '@angular/core';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSliderModule } from '@angular/material/slider';
import { MatTabsModule } from '@angular/material/tabs';
import { MatSortModule } from '@angular/material/sort';
import { ReactiveFormsModule } from '@angular/forms';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule } from '@angular/material/button';
import { CustomersComponent } from './customers/customers.component';
import { MatTableModule } from '@angular/material/table';
import { OrdersComponent } from './orders/orders.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { DialogboxComponent } from './dialogbox/dialogbox.component';
import { FormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSidenavModule } from '@angular/material/sidenav';
import { SuppliersComponent } from './suppliers/suppliers.component';
import { AddcustomersComponent } from './addcustomers/addcustomers.component';
import { HttpClientModule } from '@angular/common/http';
import { AddsuppliersComponent } from './addsuppliers/addsuppliers.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { CustomerOrderComponent } from './components/CustomerOrderComponent/customer-order/customer-order.component';
import { HomeComponent } from './components/HomeComponent/home/home.component';
import { ProductsComponent } from './components/ProductsComponent/products/products.component';
import { AddproductsComponent } from './addproducts/addproducts.component';
import { AllproductsComponent } from './allproducts/allproducts.component';
import { AddCustomerProductComponent } from './components/add-customer-product/add-customer-product.component';
import { SupplierPurchasesComponent } from './components/SupplierPurchases/supplier-purchases/supplier-purchases.component';
import { PurchaseProductComponent } from './components/PurchaseProductComponent/purchase-product/purchase-product.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CustomersComponent,
    OrdersComponent,
    DialogboxComponent,
    SuppliersComponent,
    AddcustomersComponent,
    AddsuppliersComponent,
    CustomerOrderComponent,
    HomeComponent,
    ProductsComponent,
    AddproductsComponent,
    AllproductsComponent,
    AddCustomerProductComponent,
    SupplierPurchasesComponent,
    PurchaseProductComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatSortModule,
    MatCheckboxModule,
    MatButtonModule,
    MatTabsModule,
    MatTableModule,
    MatFormFieldModule,
    MatSelectModule,
    FormsModule,
    MatDialogModule,
    MatSidenavModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatInputModule,
    MatToolbarModule,
    FlexLayoutModule,
    MatIconModule,
    MatPaginatorModule,
    MatAutocompleteModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [DialogboxComponent],
})
export class AppModule {}
