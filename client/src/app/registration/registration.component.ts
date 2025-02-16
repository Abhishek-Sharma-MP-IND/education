import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { HttpService } from '../../services/http.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {
  itemForm!: FormGroup;
  formModel: any;
  showMessage: boolean = false;
  responseMessage: any;
  errorMessage:any;
  showError: boolean = false;
  

  constructor(
    private formBuilder: FormBuilder,
    private httpService: HttpService,

    private authService: AuthService,
    private route :Router
  ) {}

  ngOnInit(): void {
      this.itemForm = this.formBuilder.group({
        email: ['', [Validators.required, Validators.pattern(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/)]],
        password: ['', [Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/)]],
        role: [null, Validators.required],
        username: ['', [Validators.required, Validators.pattern(/^[a-zA-Z]{4,15}$/)]]
      });
    }

  onRegister(): void {
    if (this.itemForm.valid) {
      this.formModel = this.itemForm.value;
      // Call HTTP service to register
      this.httpService.registerUser(this.formModel).subscribe(
        (response) => {
          this.responseMessage = "You have Registered Successfully";
          this.showMessage = true;
          setTimeout(() => {
            this.route.navigateByUrl('/login');
          }, 1000);
        },
        (error) => {
          
          this.showMessage = true;
          this.showError = true;
          this.responseMessage = "User Already Exists!";
        }
      );
    }
  }
}