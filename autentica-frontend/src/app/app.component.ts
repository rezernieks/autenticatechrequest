import { Component, OnInit } from '@angular/core';
import { TechRequest } from './techrequest';
import { TechRequestService } from './techrequest.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public techrequests: TechRequest[] = [];

  constructor(
    private techrequestService: TechRequestService, 
  ) {}

  ngOnInit(): void {
    this.getTechRequests();
  }

  public getTechRequests(): void {
    this.techrequestService.getTechRequests().subscribe(
      (response: TechRequest[]) => {
        this.techrequests = response;
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    );
    
  }

  public acceptTechRequest(techrequestId: number): void {
    this.techrequestService.acceptTechRequests(techrequestId).subscribe(
      (response: string) => {
        console.log(response);
        this.getTechRequests(); // refreshes the techrequests data
      },
      (error: HttpErrorResponse) => {
        this.getTechRequests();
        console.log(error.message);
      }
    );
  }

  public declineTechRequest(techrequestId: number): void {
    this.techrequestService.declineTechRequests(techrequestId).subscribe(
      (response: string) => {
        console.log(response);
        this.getTechRequests(); // refreshes the techrequests data
        location.reload()
      },
      (error: HttpErrorResponse) => {
        this.getTechRequests();
        console.log(error.message);
      }
    );
  }

  public deleteTechRequest(techrequestId: number): void {
    this.techrequestService.deleteTechRequests(techrequestId).subscribe(
      (response: string) => {
        console.log(response);
        this.getTechRequests(); // refreshes the techrequests data
      },
      (error: HttpErrorResponse) => {
        this.getTechRequests();
        console.log(error.message);
      }
    );
  }

  public onAddTechRequest(addForm: NgForm): void {
    debugger;
    //document.getElementById('add-techrequest-form').click();
    this.techrequestService.addTechRequests(addForm.value).subscribe(
      (response: string) => {
        console.log(response);
        this.getTechRequests();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
        this.getTechRequests();
        addForm.reset();
      }
    );
}

}
