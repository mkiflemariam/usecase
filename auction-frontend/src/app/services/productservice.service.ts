import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {
  url = "http://localhost:8090/products";
  constructor(private http: HttpClient) { }

  getProducts():Observable<Product[]>{
    return this.http.get<Product[]>(this.url);
  }

  getProduct(id:number):Observable<Product>{
    return this.http.get<Product>(`${this.url}/${id}`);
  }
}
