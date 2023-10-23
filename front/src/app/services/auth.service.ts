import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { User } from 'src/app/interfaces/user.interface';
import { RegisterRequest } from '../interfaces/auth/registerRequest.interface';
import { AuthSuccess } from '../interfaces/auth/authSuccess.interface';
import { LoginRequest } from '../interfaces/auth/loginRequest.interface';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private pathService = 'http://localhost:3001/api/auth';
  private headers = new HttpHeaders({
    'Access-Control-Allow-Origin' : '*',
    'Access-Control-Allow-Headers' : 'Content-Type',
    'Content-Type': 'application/json',
    Accept: 'application/json'
  });
  constructor(private http: HttpClient) { }

  public register(registerRequest: RegisterRequest): Observable<AuthSuccess> {
    JSON.stringify(registerRequest);

    return this.http.post<AuthSuccess>('http://localhost:3001/api/auth/register', registerRequest, { headers: this.headers})
    .pipe(
      tap()
      );
  }

  public login(loginRequest: LoginRequest): Observable<AuthSuccess> {
    JSON.stringify(loginRequest);

    return this.http.post<AuthSuccess>(`http://localhost:3001/api/auth/login`, loginRequest, { headers: this.headers});
  }

  public me(token: String): Observable<User> {

    const headersGetMe = new HttpHeaders({
      "Authorization": "Token " + token
    });
    

    return this.http.get<User>(`${this.pathService}/me`, { headers: headersGetMe});
  }
}
