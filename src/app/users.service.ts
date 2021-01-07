import { Userdetailspayload } from './userdetailspayload';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({ 
  providedIn: 'root'
})
export class UsersService {

   private baseURL ="http://localhost:8080/api/v1/users";
   private registerURL="http://localhost:8080/api/v1/register_user";
   private getUserURL ="http://localhost:8080/api/v1/user";
   private updateUserURL="http://localhost:8080/api/v1/update_user";
   private deleteUserURL="http://localhost:8080/api/v1/delete_user";
  constructor( private httpClient: HttpClient) { }   

  getUsersList(): Observable<Userdetailspayload[]>{
    return this.httpClient.get<Userdetailspayload[]> (`${this.baseURL}`);
  }

  registerUser(user: Userdetailspayload): Observable<object>{
    return this.httpClient.post(`${this.registerURL}`, user);
  }

  getUserById(id: number): Observable<Userdetailspayload>{
      return this.httpClient.get<Userdetailspayload>(`${this.getUserURL}/${id}`);
  }

  updateUser(id: number, user: Userdetailspayload):Observable<Object>{
      return this.httpClient.put(`${this.updateUserURL}/${id}`, user);
  }
  deleteUser(id: number): Observable<object>{
    return this.httpClient.delete(`${this.deleteUserURL}/${id}`);
  }
} 
