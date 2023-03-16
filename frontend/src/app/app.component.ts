import { Component } from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { Router } from '@angular/router';
import { searchQueryData } from 'src/Model/SharedData';
import { SharedDataServiceService } from './service/shared-data-service.service';
import { StockServiceService } from './service/stock-service.service';
import { stock } from 'src/Model/Stocks';
import { DatePipe } from '@angular/common';
import { ErrorDialogueComponent } from './dilog/error-dialogue/error-dialogue.component';
import { MatDialog } from '@angular/material/dialog';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})

export class AppComponent {
  constructor(private router:Router, private sharedService:SharedDataServiceService, private stockService:StockServiceService,private dilog:MatDialog) { 
       this.stockService.getall().subscribe((res)=>{
          this.dataSource = <stock[]>res;
       },
       (message)=>{
        let dilog:any
         if(message.status===0){
          dilog=this.dilog.open(ErrorDialogueComponent,{
            data: { message: "Unable to connect with server." }
          });
         }
         else{
          dilog=this.dilog.open(ErrorDialogueComponent,{
            data: { message}
          });
         }
         
       }
       )
  }

  title = 'StockApplication';
  dataSource: stock[] | undefined;

  columnsToDisplay = ['company', 'companyCode', 'price'];
  columnsToDisplayWithExpand = [...this.columnsToDisplay, 'expand'];
  expandedElement!: PeriodicElement | null;
  sDate:any='';
  eDate:any='';
  pipe = new DatePipe('en-US');
  

  

  startDate(type: string, event: MatDatepickerInputEvent<Date>) {
    this.sDate = this.getDate(event); 
  }
  
  endDate(type: string, event: MatDatepickerInputEvent<Date>, element:stock) {
    this.eDate = this.getDate(event);
    let data:searchQueryData = {stock:element, startDate:this.sDate.toString(), endDate:this.eDate.toString()};
    this.sharedService.set(data);
    this.router.navigate(['/stockDetails']);
  }

   getDate(event: MatDatepickerInputEvent<Date>){
      let date= this.pipe.transform(event.value, 'dd-MM-yyyy');
      return date;
  }
}


export interface PeriodicElement {
  company: string;
  price: number;
  change: string;
  description: string;
}

