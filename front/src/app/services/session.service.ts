import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { CookieHelperService } from './cookie-helper.service';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(
    private cookieHelperService: CookieHelperService
  ){}

  public isLogged: boolean = this.cookieHelperService.getCookie("token").length > 0; //TODO or undefined ?

  public isLoggedSubject = new BehaviorSubject<boolean>(this.isLogged);

  public islogged(){
    var tokenCookieValue: string = this.cookieHelperService.getCookie("token");
    this.isLogged = tokenCookieValue.length > 0 ? true : false ; //he have a token store in cookies ?
    this.next();
    return this.isLogged;
  }

  private next(): void {
    this.isLoggedSubject.next(this.isLogged);
  }
}
