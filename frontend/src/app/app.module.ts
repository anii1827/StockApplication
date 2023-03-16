import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatDividerModule } from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import { MatNativeDateModule } from '@angular/material/core';
import { CommonModule } from '@angular/common';
import { CompanyDetailsComponent } from './company-details/company-details.component';
import { HeaderComponent } from './header/header.component';
import {MatCardModule} from '@angular/material/card';
import { HomeComponent } from './admin/home/home.component';
import {MatInputModule} from '@angular/material/input';
import { AppRoutingModule } from './app-routing.module';
import { MainPageComponent } from './main-page/main-page.component';
import { LoginComponent } from './admin/login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { SuccessDialogueComponent } from './dilog/success-dialogue/success-dialogue.component';
import {MatDialogModule} from '@angular/material/dialog';
import { ErrorDialogueComponent } from './dilog/error-dialogue/error-dialogue.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CompanyDetailsComponent,
    HomeComponent,
    MainPageComponent,
    LoginComponent,
    FooterComponent,
    SuccessDialogueComponent,
    ErrorDialogueComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatDividerModule,
    MatListModule,
    MatTableModule,
    MatIconModule,
    CommonModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [MainPageComponent]
  // bootstrap: [CompanyDetailsComponent]
  // bootstrap: [HomeComponent]
})
export class AppModule { }
