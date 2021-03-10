import { AllproductsComponent } from './allproducts/allproducts.component';
import { AddsuppliersComponent } from './addsuppliers/addsuppliers.component';
import { AddcustomersComponent } from './addcustomers/addcustomers.component';
import { SuppliersComponent } from './suppliers/suppliers.component';
import { CustomersComponent } from './customers/customers.component';

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OrdersComponent } from './orders/orders.component';
import { HomeComponent } from './components/HomeComponent/home/home.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'customers',
    component: CustomersComponent,
  },

  {
    path: 'orders',
    component: OrdersComponent,
  },

  {
    path: 'suppliers',
    component: SuppliersComponent,
  },

  {
    path: 'addcustomers',
    component: AddcustomersComponent,
  },
  {
    path: 'addsuppliers',
    component: AddsuppliersComponent,
  },
  {
    path: 'allproducts',
    component: AllproductsComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
