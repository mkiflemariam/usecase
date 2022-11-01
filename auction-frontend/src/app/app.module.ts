import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

import { ProductlistComponent } from './components/productlist/productlist.component';
import { BidlistComponent } from './components/bidlist/bidlist.component';

@NgModule({
  declarations: [
    AppComponent,
    
    ProductlistComponent,
    BidlistComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
