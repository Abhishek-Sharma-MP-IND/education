import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';
@Component({
  selector: 'app-resource-allocate',
  templateUrl: './resource-allocate.component.html',
  styleUrls: ['./resource-allocate.component.scss']
})
export class ResourceAllocateComponent implements OnInit{
 
//todo: complete missing code..
      itemForm: FormGroup;
      formModel: any = {};
      showError: boolean = false;
      errorMessage: any;
      resourceList: any = [];
      assignModel: any = {};
      showMessage: boolean = false;
      responseMessage: any;
      eventList: any = [];
 
      constructor(private fb: FormBuilder, private httpService: HttpService, private router :Router) {
        this.itemForm = this.fb.group({
          eventId: ['', Validators.required],
          resourceId: ['', Validators.required],
          allocationDetails: ['', Validators.required]
        });
      }
 
      ngOnInit(): void {
        this.getEvent();
        this.getResources();
      }
 
      getEvent() {

        this.httpService.GetAllevents().subscribe(
          (data: any) => {
            this.eventList = data;
          },
          (error:any) => {
            this.showError = true;
            // this.errorMessage = error.message;
            this.errorMessage = 'Error fetching events';

            setTimeout(() => {
              this.showError = false;
            }, 3000);

          }
        );
      }
 
      getResources() {
        this.httpService.GetAllResources().subscribe(
          (data: any) => {
            this.resourceList = data;
          },
          (error:any) => {
            this.showError = true;
            // this.errorMessage = error.message;
            this.errorMessage = 'Error fetching Resources';

            setTimeout(() => {
              this.showError = false;
            }, 3000);

          }
        );
      }
 
      onSubmit() {
        if (this.itemForm.invalid) {
          this.showError = true;
          this.errorMessage = 'All fields are required';

          setTimeout(() => {
            this.showError = false;
          }, 3000);

          return;
        }
        this.httpService.allocateResources(
          this.itemForm.value.eventId,
          this.itemForm.value.resourceId,
          { details: this.itemForm.value.allocationDetails }
        ).subscribe(
          (response:any) => {
            this.showMessage = true;
            this.responseMessage = 'Resource allocated successfully!';
            setTimeout(() => {
              this.router.navigateByUrl('/dashboard');
            }, 2000);
            // this.itemForm.reset();
          },
          (error:any) => this.handleError(error)
        );

      }
 
      handleError(error: any) {
        this.showError = true;
        this.errorMessage = error.error?.message || 'Something went wrong'
        setTimeout(() => {
          this.showError = false;
        }, 3000);;

      }
     
}