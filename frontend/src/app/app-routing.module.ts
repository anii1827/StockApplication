import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { CompanyDetailsComponent } from './company-details/company-details.component';
import { HomeComponent } from './admin/home/home.component';
import { LoginComponent } from './admin/login/login.component';
import { AuthGuard } from './service/auth.guard';
import { TokeResolverResolver } from './resolver/toke-resolver.resolver';

const routes: Routes = [
  { path: '', redirectTo: '/stocks', pathMatch: 'full'},
  { path: 'stocks', component: AppComponent },
  { path: 'stockDetails',  component: CompanyDetailsComponent},
  { path: 'home', component: HomeComponent,
   canActivate:[AuthGuard],
   resolve:{data:TokeResolverResolver}
  },
  { path: 'login', component: LoginComponent},
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes, { useHash: true }),
  ],
  exports: [
    RouterModule,
  ]
})
export class AppRoutingModule { }
