import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-error-dialogue',
  templateUrl: './error-dialogue.component.html',
  styleUrls: ['./error-dialogue.component.css']
})
export class ErrorDialogueComponent implements OnInit {

  message:String="error";
  constructor(private dialogRef: MatDialogRef<ErrorDialogueComponent>,@Inject(MAT_DIALOG_DATA) private data: {message: string}) { }

  ngOnInit(): void {
    this.message = this.data.message;
  }

  close(){
    this.dialogRef.close();
  }

}
