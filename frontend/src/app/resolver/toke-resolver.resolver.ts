import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { LoginServiceService } from '../service/login-service.service';

@Injectable({
  providedIn: 'root'
})
export class TokeResolverResolver implements Resolve<any> {
  
  constructor(private router:Router, private login:LoginServiceService){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if(localStorage.getItem('token')===null){
      this.router.navigate(['/login']);
    }
    this.login.validateToken().subscribe((res)=>{
        
    },
    (error)=>{
        localStorage.removeItem('token');
        this.router.navigate(['/login']);
    });
  }
  
}
