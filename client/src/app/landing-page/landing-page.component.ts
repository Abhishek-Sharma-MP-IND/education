import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.scss']
})
export class LandingPageComponent implements OnInit {

  name:string = ''; 
  email: string = ''; 
  message: string = ''; 
  successMessage: string = ''; 
  onSubmit() { 
    if (this.name.trim() && this.email.trim() && this.message.trim()) 
    { 
      this.successMessage = 'Thank you! Your message has been sent successfully.'; 
      this.resetForm(); 
    } 
  } 

  resetForm() 
  { 
    this.name = ''; 
    this.email = ''; 
    this.message = ''; 
  }

  constructor() { }

  ngOnInit(): void {

  }

teamMembers = [
  { name: 'Abhishek S', role: 'Team Leader', logo: 'assets/team/abhishek.png' },
  { name: 'Ramya A', role: 'Contributor', logo: 'assets/team/ramya.png' },
  { name: 'Aviral V', role: 'Contributor', logo: 'assets/team/aviral.png' },
  { name: 'Sravani G', role: 'Contributor', logo: 'assets/team/shravani.png' },
  { name: 'Shivraj S', role: 'Contributor', logo: 'assets/team/shivraj.png' }

];

scrollToSection(sectionId: string): void {
    const element = document.getElementById(sectionId);
    if (element) {
      element.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }
  }

  


} 