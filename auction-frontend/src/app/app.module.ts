import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatDividerModule} from '@angular/material/divider';

import { AppComponent } from './app.component';

import { ProductlistComponent } from './components/productlist/productlist.component';
import { BidlistComponent } from './components/bidlist/bidlist.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    
    ProductlistComponent,
    BidlistComponent
  ],
  imports: [
    BrowserModule,MatDividerModule,MatGridListModule,MatToolbarModule, BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
