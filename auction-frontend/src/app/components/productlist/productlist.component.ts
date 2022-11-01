import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {
  products: Product[] = [{productId: "1", productName:"Tv", quantity:10, description:"Colour tv"},
  {productId: "2", productName:"Laptop", quantity:10, description:"Colour tv"},
  {productId: "3", productName:"CD", quantity:10, description:"Colour tv"},
  {productId: "4", productName:"Desctop", quantity:10, description:"Colour tv"},
  {productId: "5", productName:"TapeRecorder", quantity:10, description:"Colour tv"},
  {productId: "6", productName:"Dish", quantity:10, description:"Colour tv"}
];
  constructor() { }

  ngOnInit(): void {
  }

}
