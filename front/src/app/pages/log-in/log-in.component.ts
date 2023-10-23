import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { LoginRequest } from 'src/app/interfaces/auth/loginRequest.interface';
import { AuthSuccess } from 'src/app/interfaces/auth/authSuccess.interface';
import { User } from 'src/app/interfaces/user.interface';
import { Router } from '@angular/router';
import { SessionService } from 'src/app/services/session.service';
import { AuthService } from 'src/app/services/auth.service';

//TODO try   ?? selector: 'log-in', ??

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss'],
})
export class LogInComponent implements OnInit {
  public hide = true;
  public onError = false;
  public testErrorMessage = "";

  //TODO no any, model datas !
  formData: LoginRequest ={
    identifier: '',
    password: ''
  };
  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService, 
    private router: Router,
    private sessionService: SessionService
    ) { }

  ngOnInit(): void {
  }

  public form = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.min(3)]]
  });

  public submit2(): void {
    this.authService.login(this.formData).subscribe(
      (response: AuthSuccess) => {
        localStorage.setItem('token', response.token);
        this.authService.me(response.token).subscribe((user: User) => {
          this.sessionService.logIn(user);
          this.router.navigate(['/articles'])
        });
        this.router.navigate(['/logIn'])
      },
       error => this.onError = true
    );
  }
  
  emailControl= new FormControl([Validators.required]);

  getEmailErrorMessage(){
    if(this.emailControl.hasError('required')){
      return 'required';
    }

    return 'unknow error';
  }

  goBack(){
    window.history.back();
  }

}
