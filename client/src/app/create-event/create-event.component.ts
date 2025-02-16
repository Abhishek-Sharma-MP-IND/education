import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';
 
 
@Component({
  selector: 'app-create-event',
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.scss']
})
 
export class CreateEventComponent implements OnInit {
  itemForm!: FormGroup;
  formModel: any = {};
  showError: boolean = false;
  errorMessage: any = [];
  eventList: any = [];
  assignModel: any = {};
  showMessage: any = false;
  responseMessage: any = '';
 
 
  constructor(private fb: FormBuilder, private httpService: HttpService, private authService: AuthService, private route :Router) {
    this.itemForm = this.fb.group({
      name: ['', [Validators.required]],
      description: ['', [Validators.required]],
      materials: ['', [Validators.required]]
    });
  }
 
  ngOnInit(): void {
    this.getEvent();
  }
 
  getEvent(): void {
    this.httpService.GetAllevents().subscribe(
      (data: any) => {
        this.eventList = data;
      },

      (error:any) => {
        this.showError = true;
        // this.errorMessage = error.message;
        this.errorMessage = 'Error fetching events';

      }
    );
  }
 
  onSubmit(): void {
    if (this.itemForm.valid) {
      this.httpService.createEvent(this.itemForm.value).subscribe((data)=>{
        console.log(data);
      this.showMessage = true;
      this.responseMessage = 'Event created successfully!';
      setTimeout(() => {
        this.route.navigateByUrl('/dashboard');
      }, 2000);
      });
      
    } else {
      this.showError = true;
      this.errorMessage = 'Please fill in all required fields.';

      setTimeout(() => {
        this.showError = false;
      }, 3000);

    }
  }
}
 