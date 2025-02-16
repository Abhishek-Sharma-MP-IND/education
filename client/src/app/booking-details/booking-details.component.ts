
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-booking-details',
  templateUrl: './booking-details.component.html',
  styleUrls: ['./booking-details.component.scss']
})
export class BookingDetailsComponent implements OnInit {
  studentId: string = '';
  bookingDetails: any[] = [];

  constructor(private httpService: HttpService, private auth:AuthService) {}

  ngOnInit(): void {
    this.studentId = this.auth.getId();
   this.fetchBookingDetails()
  }

  fetchBookingDetails(): void {
    this.httpService.getBookingDetails(this.studentId).subscribe(
      (response) => {
        this.bookingDetails = response || [];
      },
      (error) => {
        console.error('Error fetching booking details:', error);
        this.bookingDetails = [];
      }
    );
  }
}