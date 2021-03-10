import { Component, OnInit } from '@angular/core';

import Typed from 'typed.js';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  str = ["Add Customers", "Add Orders for Customers", "Add or Update products in Orders", "Change Order Status",
        "Add Suppliers", "Add purchases from Suppliers", "Add or update purchases", "Change purchase Status"];

  ngOnInit(): void {

    const options = {
      strings: this.str,
      typeSpeed: 30,
      backSpeed: 30,
      showCursor: false,
      cursorChar: '|',
      loop: true
    };
    const typed = new Typed('.element', options);

  }

}
