import { DatePipe, getLocaleDateFormat } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { ActivatedRoute, Router } from '@angular/router';
import { searchQueryData } from 'src/Model/SharedData';
import { SharedDataServiceService } from '../service/shared-data-service.service';
import { StockServiceService } from '../service/stock-service.service';

@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.css']
})
export class CompanyDetailsComponent implements OnInit {
  displayedColumns: string[] = ['price', 'startTime', 'endTime'];
  dataSource:any;
  events: string[] = [];
  constructor(private sharedService:SharedDataServiceService, private stockService:StockServiceService) { }
  companyName:String='';
  companyCode:String='';
  Currentprice:number=0.0;
  max:number=0.0;
  min:number=0.0;
  average:number=0.0;
  sDate:any='';
  eDate:any='';
  ngOnInit(): void {
    let data = this.sharedService.get();
  
    if(data==null){
      let json: string = sessionStorage.getItem('data')+'';
      data = JSON.parse(json.toString());

    }else{
    this.setData(data);
    //before calling the rest api check in local Storage data present or not.
    //else call the rest api to fetch the data.
    }
    this.companyCode= data.stock.companyCode;
    this.Currentprice = data.stock.price;
    this.companyName = data.stock.companyName;
    this.getData(data.stock.companyCode,data.startDate,data.endDate);  
  }


  public setData(data:any){
    sessionStorage.setItem('data',JSON.stringify(data));
  }

  getData(CompCode:String,sDate:String,eDate:String){
    this.stockService.getDataByStartAndEndDate(CompCode,sDate,eDate).subscribe((res)=>{
      this.max=res.max;
      this.min=res.min;
      this.average=res.average;
      this.dataSource=res.stocks;
    },
    (error)=>{
        console.log(error);
    })
  }

  startDate(type: string, event: MatDatepickerInputEvent<Date>) {
    this.sDate=this.getDate(event);
  }
  
  endDate(type: string, event: MatDatepickerInputEvent<Date>) {
    this.eDate=this.getDate(event);
    this.getData(this.companyCode, this.sDate.toString(),this.eDate.toString());
    let json: string = sessionStorage.getItem('data')+'';
     let data: searchQueryData = JSON.parse(json.toString());
     data.startDate = this.sDate;
     data.endDate = this.eDate;
     this.setData(data);
  }

  getDate(event: MatDatepickerInputEvent<Date>){
    let pipe = new DatePipe('en-US');
    let date= pipe.transform(event.value, 'dd-MM-yyyy');
    return date;
}

}

export interface PeriodicElement {
  price: string;
  startTime: number;
  endTime: string;
}




