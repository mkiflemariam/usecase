import { Component, OnInit } from '@angular/core';
import { Bid } from 'src/app/model/bid';
import { Product } from 'src/app/model/product';
import { ProductserviceService } from 'src/app/services/productservice.service';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {
  products!: Product[];
  product!: Product;
  selectedProduct!:number;
 
  bids:Bid[]=[
    {
    amount: 12,
    name:"name2",
    email:"email1",
    mobile:"12345"
  },
    {
    amount: 13,
    name:"name1",
    email:"email1",
    mobile:"12345"
  },
    {
    amount: 13,
    name:"name3",
    email:"email1",
    mobile:"12345"
  },
    {
    amount: 14,
    name:"name4",
    email:"email1",
    mobile:"12345"
  }
];
  constructor(private productService : ProductserviceService) { }

  ngOnInit(): void {
    this.productService.getProducts().subscribe(data => {
      console.log(data);
      this.products = data;
    });
    this.selectedProduct=11;
    
    this.productService.getProduct(this.selectedProduct).subscribe(
      
      (data:Product)=>{
        this.product=data;
        console.log(this.product);
      
    });
    
  }

  getProductById = (id:number) =>{
  
  }

  onChange = (e:any) => {
    console.log(e);
    ()=>this.getButtonClick()
  }
  getButtonClick = ()=>{
    this.productService.getProduct(this.selectedProduct).subscribe(
      
      (data:Product)=>{
        this.product=data;
        console.log(this.product);
      
    })
   }

}
