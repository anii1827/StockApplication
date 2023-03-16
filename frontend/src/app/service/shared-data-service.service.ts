import { Injectable } from '@angular/core';
import { searchQueryData } from 'src/Model/SharedData';

@Injectable({
  providedIn: 'root'
})
export class SharedDataServiceService {
  search!:searchQueryData
  constructor() { }

 public set(data:searchQueryData):void{
  this.search=data;
 }

  public get():searchQueryData{
    return this.search;
  }
}
