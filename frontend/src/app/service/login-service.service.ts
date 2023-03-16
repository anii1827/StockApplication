import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  baseUrl: string = environment.baseURL+"api/v1.0/market/auth/";

  constructor(private http: HttpClient) { }

  authenticate(userName:String,Password:String){
    let url = this.baseUrl+"login";
    let data: loginData = {
          username: userName,
          password: Password
        }
    return this.http.post(url,data,{responseType: 'text'});
  }

  validateToken(){
    let token = localStorage.getItem('token');
    let url = environment.baseURL+"isExpired";
    return this.http.post(url,token,{responseType: 'text'});
  }
}

interface loginData{
    username:String;
    password:String;
}
