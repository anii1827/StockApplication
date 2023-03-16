import { devOnlyGuardedExpression } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormControlName, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ErrorDialogueComponent } from 'src/app/dilog/error-dialogue/error-dialogue.component';
import { SuccessDialogueComponent } from 'src/app/dilog/success-dialogue/success-dialogue.component';
import { AdminServiceService } from 'src/app/service/admin-service.service';
import { LoginServiceService } from 'src/app/service/login-service.service';
import { StockServiceService } from 'src/app/service/stock-service.service';
import { stock } from 'src/Model/Stocks';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    registerGroup=new FormGroup({
    companyName: new FormControl('',Validators.required),
    companyCode: new FormControl('',Validators.required),
    companyCeo: new FormControl('',Validators.required),
    companyWebsite: new FormControl('',Validators.required),
    companyTurnover: new FormControl('',Validators.required),
    companyInitialPrice: new FormControl('',Validators.required),
  });

  
    updateGroup = new FormGroup({
      compCode:new FormControl('',[Validators.required, Validators.pattern(/^[^a-z]*$/)]),
      updatedprice:new FormControl('',[Validators.required,Validators.pattern(/^-?(0|[1-9]\d*)?$/)])
    });
 
  displayedColumns: string[] = ['company', 'companyCode', 'price', 'delete'];
  dataSource:stock[]=[];

  constructor(private adminService:AdminServiceService,private stockService:StockServiceService,private dilog:MatDialog, private router: Router, private login:LoginServiceService) {
  
  }

  ngOnInit(): void {
    // if(localStorage.getItem('token')===null){
    //   this.router.navigate(['/login']);
    // }
    // this.login.validateToken().subscribe((res)=>{
      this.getAllStockDetails();
    // },
    // (error)=>{
    //   if(error['status']===408){
    //     this.router.navigate(['/login']);
    //   }
    // });
  }


  getAllStockDetails(){
    this.stockService.getall().subscribe((res)=>{
      this.dataSource = <stock[]>res;
   },
   (error)=>{
     this.handleError(error);
   }
   )
  }

  deleteData(data:stock){
    this.adminService.deleteTheCompany(data.companyCode).subscribe(res=>{
      this.dilog.open(SuccessDialogueComponent,{
        data: { message: res }
      });
      this.refresh();
    },
    (error)=>{
      console.log(error);
      this.handleError(error);
    })
}

  Register(){
      if(!this.registerGroup.valid){
        for (let el in this.registerGroup.controls) {
          if (this.registerGroup.controls[el].errors) {
            alert(el+" value should not be null");
            return;
          }
     }  
        
      }
      this.adminService.registerCompany(this.getTheRegisterData()).subscribe((res)=>{
          console.log(res);
          this.dilog.open(SuccessDialogueComponent,{
            data: { message: res }
          });
          this.refresh();
          this.registerGroup.reset();
      },
      (error)=>{
        this.handleError(error);
      })
  }

  refresh(){
    this.getAllStockDetails();
  }
  getTheRegisterData(){
    let data: registerDTO={
        companyCode: this.registerGroup.get('companyCode')?.value,
        companyName: this.registerGroup.get('companyName')?.value,
        companyCEO: this.registerGroup.get('companyCeo')?.value,
        turnOver: this.registerGroup.get('companyTurnover')?.value,
        companyWebsite: this.registerGroup.get('companyWebsite')?.value,
        initialPrice:  this.registerGroup.get('companyInitialPrice')?.value,
    }
    return data;
  }


  Update(){
    if(!this.updateGroup.valid){
      if(this.updateGroup.get('compCode')?.value===''){
        alert("Company Code value should not be null");
        return;
      }
      if(this.updateGroup.get('updatedprice')?.value===''){
        alert("Update Price value should not be null");
        return;
      }
      let regex = "/^[^a-z]*$/";
      if(!regex.match(this.updateGroup.get('compCode')?.value)){
        alert("Company code should be in uppercase letter");    
        return;
      }
      alert("Price Value should be number");
      return;
    }

    console.log(this.getTheUpdatePriceData());
    this.adminService.updateStockPrice(this.getTheUpdatePriceData()).subscribe((res)=>{
      console.log(res);
      const dilog =this.dilog.open(SuccessDialogueComponent,{
        data: { message: res }
      });
      dilog.afterClosed().subscribe((res)=>{
      this.refresh();
      this.updateGroup.reset();
    });
    },
    (error)=>{
      this.handleError(error);
    })
  }


  handleError(error:any){
    console.log(error);
    let dilog;
    if(error['status']===408){
       dilog =this.dilog.open(ErrorDialogueComponent,{
        data: { message: "Your Session has been expired." }
      }).afterClosed().subscribe((res)=>{
        this.router.navigate(['/login']);
        localStorage.removeItem('token');
      });
      
    }
    else{
      if(error['error']!==''){
         dilog =this.dilog.open(ErrorDialogueComponent,{
          data: { message: error['error'] }
        });
        this.updateGroup.reset();
      }
      else{
        const dilog =this.dilog.open(ErrorDialogueComponent,{
          data: { message: error['message'] }
        });
        this.updateGroup.reset();
      }
      
    }
   
  }
  getTheUpdatePriceData(){
    let data:updatePriceDTO={
      companyCode:this.updateGroup.get('compCode')?.value,
      price:this.updateGroup.get('updatedprice')?.value
    }
    return data;
  }

}

export interface registerDTO{
  companyCode:String;
	companyName:String;
	companyCEO:String;
	turnOver:String;
	companyWebsite:String;
	initialPrice:number;
}

export interface updatePriceDTO{
    companyCode:String;
		price:String;
}

export interface PeriodicElement {
  company: string;
  price: number;
  change: number;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {company: 'Hydrogen', price: 1.0079, change: -20},
  {company: 'Helium', price: 4.0026, change: 20},
  {company: 'Lithium', price: 6.941, change: 10},
  {company: 'Beryllium', price: 9.0122, change: 1},
  {company: 'Boron', price: 10.811, change: 2},
  {company: 'Carbon', price: 12.0107, change: -4},
  {company: 'Nitrogen', price: 14.0067, change: -2},
  {company: 'Oxygen', price: 15.9994, change: 1},
  {company: 'Fluorine', price: 18.9984, change: -0.5},
  {company: 'Neon', price: 20.1797, change: 1},
  {company: 'Hydrogen', price: 1.0079, change: -20},
  {company: 'Helium', price: 4.0026, change: 20},
  {company: 'Lithium', price: 6.941, change: 10},
  {company: 'Beryllium', price: 9.0122, change: 1},
  {company: 'Boron', price: 10.811, change: 2},
  {company: 'Carbon', price: 12.0107, change: -4},
  {company: 'Nitrogen', price: 14.0067, change: -2},
  {company: 'Oxygen', price: 15.9994, change: 1},
  {company: 'Fluorine', price: 18.9984, change: -0.5},
  {company: 'Neon', price: 20.1797, change: 1},
  
];