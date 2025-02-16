import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-register-for-event',
  templateUrl: './register-for-event.component.html',
  styleUrls: ['./register-for-event.component.scss']
})
export class RegisterForEventComponent implements OnInit {

  formModel: any = {};
  showError: boolean = false;
  errorMessage: any;
  eventObj: any = {};
  assignModel: any = {};
  events: any[] = [];
  showMessage: any;
  responseMessage: any;
  isUpdate: any;

  registeredEvents: any[] = [];
  studentId: any;
  registrationStatus: any;
  eventId: any;

  constructor(public router: Router, private formBuilder: FormBuilder, private authService: AuthService, private httpService: HttpService) { }

  ngOnInit(): void {
    this.fetchEvents()
    this.studentId = this.authService.getId();
  }
  onRegister(eventId: any) {
    this.eventId = eventId;
    if (this.eventId && this.studentId) {
      const details = { studentId: this.studentId, status: "Registered" }; // Only send studentId in body
      this.httpService.registerForEvent(this.eventId, details).subscribe(
        () => {
          this.showMessage = true;
          this.showError = false;
          this.responseMessage = 'Registration successful!';
          setTimeout(() => {
            this.showMessage = false
            this.showError = false
            this.responseMessage = ''
          }, 2000);
        },
        (error) => {
          if (error.status === 409) {
            this.showMessage = true;
            this.showError = true;
            this.responseMessage = 'You are already registered for this event.';
            setTimeout(() => {
              this.showMessage = false
              this.showError = false
              this.responseMessage = ''
            }, 2000);
          } else {
            this.showMessage = true;
            this.showError = true;
            this.responseMessage = 'Error registering for event';
          }
        }
      );
    } else {
      this.showMessage = true;
      this.responseMessage = 'Please enter both Event ID and Student ID.';
    }
  }

  fetchEvents() {
    this.httpService.GetAllevents().subscribe(
      (response) => {
        this.events = response;
      },
      () => {
        this.events = [];
      }
    );
  }

}