import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { ThemeListDTO } from '../interfaces/themeListDTO.interface';
import { ThemeDTO } from '../interfaces/themeDTO.interface';

@Injectable({
  providedIn: 'root'
})
export class ThemesService {
  private pathService = 'http://localhost:3001/api';
  private headers = new HttpHeaders({
    'Access-Control-Allow-Origin' : '*',
    'Content-Type': 'application/json',
    Accept: 'application/json'
  });

  constructor(private http: HttpClient) { }

  public getThemesList(): Observable<ThemeDTO[]> {

    return this.http.get<ThemeDTO[]>(this.pathService + '/theme/listTheme')
    .pipe(
      tap()
      );
  }

  public getThemes(): Observable<ThemeDTO[]> {

    return this.http.get<ThemeDTO[]>(this.pathService + '/theme/list')
    .pipe(
      tap()
      );
  }

  public subscribeToTheme(themeID: number){
    JSON.stringify(themeID);

    return this.http.post<number>(this.pathService + '/theme/subscribe', themeID, { headers: this.headers})
    .pipe(
      tap()
      );
  }

  public unsubscribeFromTheme(themeID: number){
    JSON.stringify(themeID);

    return this.http.post<number>(this.pathService + '/theme/unsubscribe', themeID, { headers: this.headers})
    .pipe(
      tap()
      );
  }

}
