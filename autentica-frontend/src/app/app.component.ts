import { Component, OnInit } from '@angular/core';
import { TechRequest } from './techrequest';
import { TechRequestService } from './techrequest.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public techrequests: TechRequest[] = [];

  constructor(private techrequestService: TechRequestService){}

  ngOnInit(): void {
    this.getTechRequests();
  }

  public getTechRequests(): void {
    this.techrequestService.getTechRequests().subscribe(
      (response: TechRequest[]) => {
        this.techrequests = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
