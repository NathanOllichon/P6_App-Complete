import { HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { CookieHelperService } from "../services/cookie-helper.service";

@Injectable({ providedIn: 'root' })
export class JwtInterceptor implements HttpInterceptor {
  constructor(
    private cookieHelperService:  CookieHelperService
  ) {}

  public intercept(request: HttpRequest<any>, next: HttpHandler) {
    const token = this.cookieHelperService.getCookie("token");

    if (token) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`,
        },
      });
    }
    return next.handle(request);
  }
}