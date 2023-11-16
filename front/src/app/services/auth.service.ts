import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { User } from 'src/app/interfaces/user.interface';
import { RegisterRequest } from '../interfaces/auth/registerRequest.interface';
import { AuthSuccess } from '../interfaces/auth/authSuccess.interface';
import { LoginRequest } from '../interfaces/auth/loginRequest.interface';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SessionService } from './session.service';
import { Router } from '@angular/router';
import { UserChangeRequest } from '../interfaces/auth/userChangeRequest.interface';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private pathService = 'http://localhost:3001/api/auth';
  private headers = new HttpHeaders({
    'Access-Control-Allow-Origin' : '*',
    'Content-Type': 'application/json',
    Accept: 'application/json'
  });
  constructor(private http: HttpClient,
    private sessionService: SessionService,
    private router: Router
    ) {}

  public register(registerRequest: RegisterRequest): Observable<AuthSuccess> {
    JSON.stringify(registerRequest);

    return this.http.post<AuthSuccess>('http://localhost:3001/api/auth/register', registerRequest, { headers: this.headers})
    .pipe(
      tap((response: AuthSuccess) => {
          // -2 hours because france is UTC+2
          document.cookie = `token=${response.token}; expires=${new Date(new Date().getTime()+60*60*1000*(12-2)).toUTCString()}`;
            return true;
          },
          error => {
            return false;
          })
      );
  }

  public login(loginRequest: LoginRequest): Observable<AuthSuccess> {
    JSON.stringify(loginRequest);

    return this.http.post<AuthSuccess>(`http://localhost:3001/api/auth/login`, loginRequest, { headers: this.headers})
    .pipe(
      tap( (response: AuthSuccess) => {

        // -2 hours because france is UTC+2
        document.cookie = `token=${response.token}; expires=${new Date(new Date().getTime()+60*60*1000*(12-2)).toUTCString()}`;
          return true;
        },
        error => {
          return false;
        })
    );
}

  public logout() {
    document.cookie = `token=; expires=${new Date(new Date().getTime()-1000*60*60).toUTCString()}`;
    this.sessionService.islogged();
    this.router.navigate(['']);
  }

  public me(token: String): Observable<User> {

    const headersGetMe = new HttpHeaders({
      "Authorization": "Token " + token
    });
    

    return this.http.get<User>(`${this.pathService}/me`, { headers: headersGetMe});
  }

  public updateUser(userChangeRequest: UserChangeRequest): Observable<User> {
    JSON.stringify(userChangeRequest);
    
    return this.http.post<User>(`http://localhost:3001/api/auth/updateUser`, userChangeRequest, { headers: this.headers})
    .pipe(
      tap( (response: User) => {
          return true;
        },
        error => {
          return false;
        })
    );
}




}
