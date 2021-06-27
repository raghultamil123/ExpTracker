import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AuthResponse } from '../shared/model/auth-response.model';
import { User } from '../shared/model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  readonly USER_BASE_URL = environment.BASE_URL + 'user/';
    
  constructor(private httpClient:HttpClient) { }

  authenticateUser(username:string,password:string):Observable<AuthResponse>{
      return this.httpClient.post<AuthResponse>(this.USER_BASE_URL + 'authenticate',{
        'username':username,
        'password':password
      });
  }

  getUserDetails(userId:string):Observable<User>{
    return this.httpClient.get<User>(this.USER_BASE_URL + `${userId}/user-details`)
  }
  


}
