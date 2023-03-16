import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { stock, stockCompanyStats } from 'src/Model/Stocks';

@Injectable({
  providedIn: 'root'
})
export class StockServiceService {
  baseUrl: string = environment.baseURL+"api/v1.0/market/information/";
  constructor(private http:HttpClient) { }

  getall(){
    let url = this.baseUrl+"info";
    this.http.get<stock[]>(url).subscribe((res)=>console.log(res));
     return this.http.get<stock[]>(url);
  }

  getDataByStartAndEndDate(companyCode:String,startDate:String,endDate:String){
    let queryParams = new HttpParams();
    queryParams = queryParams.append("company",companyCode.toString());
    queryParams = queryParams.append("startDate",startDate.toString());
    queryParams = queryParams.append("endDate",endDate.toString());
    let url = this.baseUrl+"infoByStartTime&EndTime";
    return this.http.get<stockCompanyStats>(url,{params:queryParams});
  }
}
