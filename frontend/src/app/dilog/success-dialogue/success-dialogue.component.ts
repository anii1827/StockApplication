import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-success-dialogue',
  templateUrl: './success-dialogue.component.html',
  styleUrls: ['./success-dialogue.component.css']
})
export class SuccessDialogueComponent implements OnInit {
  message!:String;
  constructor(private dialogRef: MatDialogRef<SuccessDialogueComponent>,@Inject(MAT_DIALOG_DATA) private data: {message: string}) { }

  ngOnInit(): void {
    this.message = this.data.message;
  }

  close():void{
    console.log("its coming");
    this.dialogRef.close();
  }
}
