import { Component, OnInit } from '@angular/core';
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
