import { Component, OnInit } from '@angular/core';
import { FormControl, SelectControlValueAccessor, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ErrorDialogueComponent } from 'src/app/dilog/error-dialogue/error-dialogue.component';
import { LoginServiceService } from 'src/app/service/login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = new FormControl('');
  password = new FormControl('');
  success: boolean = true;
  noUserName:boolean = true;
  noPassword:boolean = true;

  constructor(private router: Router, private loginService:LoginServiceService,private dilog:MatDialog) { }

  ngOnInit(): void {
  }

  invalidUser() {
    return "Username or Password is incorrect!";
  }
  
  noUser(){
    return "please provide the user name";
  }

  noPassw(){
    return "please provide the password";
  }
  validate() {
    // console.log(this.username.value);
    // console.log(this.password.value);
    if(this.username.value===''){
      this.noUserName = false;
      return;
    }
    else if(this.password.value===''){
      this.noUserName=true;
      this.noPassword = false;
      return;
    }
    this.noPassword=true;

    let user =this.username['value'];
    let pass = this.password['value'];
    this.loginService.authenticate(user.toString(),pass.toString()).subscribe((res)=>{
      localStorage.setItem('token',res);
      this.router.navigate(['/home']);
    },
    (error)=>{
      this.errorHandle(error);
    }
    )
  }
  errorHandle(error:any){
      console.log(error);
      if(error['status']===400){
        this.success=false;
      }
      else if(error.status===0){
        this.dilog.open(ErrorDialogueComponent,{
          data: { message: "Unable to connect with server." }
        });
        this.username.reset();
        this.password.reset();
      }
      else{
        this.dilog.open(ErrorDialogueComponent,{
          data: { message: error['message'] }
        });
        
      }
      this.username.reset();
      this.password.reset();
      this.noUserName=true;
      this.noPassword=true;
  }

}
