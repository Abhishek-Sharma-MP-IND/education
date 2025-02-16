import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
 

 itemForm!: FormGroup;
  errorMessage: string = '';

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private httpService: HttpService
  ) {}

  ngOnInit(): void {
    this.itemForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.itemForm.valid) {
      const { username, password } = this.itemForm.value;

      this.httpService.Login(this.itemForm.value).subscribe(
        (response) => {
         
          localStorage.setItem('token', response.token);
          localStorage.setItem('role', response.role);
          localStorage.setItem('username', response.username);
          localStorage.setItem('id', response.id);
          console.log(localStorage.getItem('id'))
          this.router.navigate(['/dashboard']); 
        },
        (error) => {
          this.errorMessage = 'Invalid username or password';
        }
      );
    }
  }







  
}
