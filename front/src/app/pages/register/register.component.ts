import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthSuccess } from 'src/app/interfaces/auth/authSuccess.interface';
import { RegisterRequest } from 'src/app/interfaces/auth/registerRequest.interface';
import { User } from 'src/app/interfaces/user.interface';
import { AuthService } from 'src/app/services/auth.service';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  public hide = true;
  public onError = false;
  public testErrorMessage = "";
  
  formData: RegisterRequest ={
    email: '',
    username: '',
    password: ''
  };

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private sessionService: SessionService,
    private router: Router
  ) {}

  ngOnInit(): void {
  }

  goBack(){
    window.history.back();
  }

  public form = this.formBuilder.group({
    //email: ['', [Validators.required, Validators.email]],
    email: ['', [Validators.required]],
    userName: ['', [Validators.required]],
    //password: ['', [Validators.required, Validators.min(3)]]
    password: ['', [Validators.required]]
  });
  
  emailControl = new FormControl([Validators.required]);
  userNameControl = new FormControl([Validators.required]);

  public submit(): void {

    this.authService.register(this.formData).subscribe({
      next: (response: AuthSuccess) => {
          this.router.navigate(['/rentals'])
      },
      error: (err: HttpErrorResponse)=> {
        this.onError = true;
      }
    });

  }

}
