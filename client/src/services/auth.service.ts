import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private token: string | null = null;
  private isLoggedIn: boolean = false;
  private id: any;

  public serverName=environment.apiUrl;

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.serverName}/login`, { username, password });
  }
  saveToken(token: string) {
    this.token = token;
    this.isLoggedIn = true;
    localStorage.setItem('token', token);
    
  }

   SetRole(role:any)
  {
    localStorage.setItem('role',role);
  }

  getRole ():string
  {
    return localStorage.getItem('role') || '';

  }
  SetUsername(role:any)
  {
    localStorage.setItem('username',role);
  }

  getUsername():string
  {
    console.log(localStorage.getItem('username'))
    return localStorage.getItem('username') || '';

  }

  SetId(id:any)
  {
    localStorage.setItem('id',id);
  }

  getId ():string
  {
    console.log(localStorage.getItem('id'))
    return localStorage.getItem('id') || '';
  }
  get getLoginStatus(): boolean {
  
      return !!localStorage.getItem('token');
   
  }
  getToken(): string | null {
   this.token= localStorage.getItem('token');
    return this.token;
  }
  
 
  logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('role');
    localStorage.removeItem('id');
    localStorage.removeItem('username');
     this.token=null;
     this.isLoggedIn=false
   }
   
   
}
