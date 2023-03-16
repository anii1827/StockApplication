import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {
  baseUrl: string = environment.baseURL+"api/v1.0/market/company/";

  constructor(private http:HttpClient) { 
    
  }

  registerCompany(data:any){
    let url = this.baseUrl+"register";
    var head = this.getHeader();
    return this.http.post(url,data, { headers: head, responseType:'text'});
  }

  private getHeader(): HttpHeaders {
    let token = localStorage.getItem('token')+'';
    const headers = new HttpHeaders({"Authorization": token });
    // console.log(headers.get('Authorization'));
    return headers;
  }

  updateStockPrice(data:any){
    let url = this.baseUrl+"updatePrice";
    var head = this.getHeader();    
    return this.http.post(url,data,{headers:head, responseType:'text'});
  }

  deleteTheCompany(companyCode:String){
    let url = this.baseUrl+"delete/"+companyCode;
    var head = this.getHeader();   
    return this.http.delete(url,{headers:head,responseType:'text'});
  }
}
