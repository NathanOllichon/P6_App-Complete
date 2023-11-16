import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserChangeRequest } from 'src/app/interfaces/auth/userChangeRequest.interface';
import { ThemeDTO } from 'src/app/interfaces/themeDTO.interface';
import { ThemeListDTO } from 'src/app/interfaces/themeListDTO.interface';
import { User } from 'src/app/interfaces/user.interface';
import { AuthService } from 'src/app/services/auth.service';
import { CookieHelperService } from 'src/app/services/cookie-helper.service';
import { ThemesService } from 'src/app/services/themes.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  actualUser!: User;

  formData: UserChangeRequest ={
    email: '',
    username: '',
  };

  themesDatasSubscribed: ThemeDTO[] = []
  onError: boolean = false;

  constructor(
    private themesService: ThemesService,
    private authService: AuthService,
    private router: Router,
    private cookieHelperService: CookieHelperService 
  ) { }

  ngOnInit(): void {
    const token = this.cookieHelperService.getCookie("token");
    this.authService.me(token).subscribe((me: User) => {
      this.actualUser = me;
      this.formData.email = this.actualUser.email;
      this.formData.username = this.actualUser.username;
    });

    this.themesService.getThemesList().subscribe(
      (response: ThemeDTO[]) => {
        this.themesDatasSubscribed = response; 
      },
      error => console.log(error)
    )
  }

  saveUser(){


    this.authService.updateUser(this.formData).subscribe(
      (updatedUser: User) => {
        if(this.actualUser.email != updatedUser.email){
          this.logOut();
        }
        this.router.navigate(['articles']);
      },
      error => console.log(error)
    );

  }
  
  subscribeTheme(themeId:number){
    this.themesService.subscribeToTheme(themeId).subscribe(); 
    this.router.navigate(['articles']);
  }

  unSubscribeTheme(themeId:number){
    this.themesService.unsubscribeFromTheme(themeId).subscribe(); 
    this.router.navigate(['articles']);
  }

  logOut(){
    this.authService.logout();
  }

}
