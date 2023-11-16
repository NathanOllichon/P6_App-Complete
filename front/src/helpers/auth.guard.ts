import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { SessionService } from 'src/app/services/session.service';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
  constructor(
    private router: Router,
    private sessionService: SessionService
    ) {}

  canActivate() {
    if (this.sessionService.islogged()) {
      return true;
    }else{
      this.router.navigate(['login']);
      return false;
    }
  }
  
}
