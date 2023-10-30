import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticlesService {
  private pathService = 'http://localhost:3001/api';

  constructor(private http: HttpClient) { }

  public getArticles(): Observable<any> {

    return this.http.get<any>(this.pathService + '/article/list')
    .pipe(
      tap()
      );
  }

  // public login(loginRequest: LoginRequest): Observable<AuthSuccess> {
  //   JSON.stringify(loginRequest);
  //   return this.http.post<AuthSuccess>(`http://localhost:3001/api/auth/login`, loginRequest, { headers: this.headers});
  // }

  // public me(token: String): Observable<User> {

  //   const headersGetMe = new HttpHeaders({
  //     "Authorization": "Token " + token
  //   });
  //   return this.http.get<User>(`${this.pathService}/me`, { headers: headersGetMe});
  // }


}
