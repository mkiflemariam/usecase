import { Component, Input, OnInit } from '@angular/core';
import { Bid } from 'src/app/model/bid';

@Component({
  selector: 'app-bidlist',
  templateUrl: './bidlist.component.html',
  styleUrls: ['./bidlist.component.css']
})
export class BidlistComponent implements OnInit {

  @Input() bid2!:Bid[];
  constructor() { }

  ngOnInit(): void {
  }

}
