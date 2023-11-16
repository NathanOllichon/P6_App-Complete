import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  constructor(private router: Router) {
    //TODO redirect if you're connected !
  }

  ngOnInit(): void {}

  routeToLogIn() {
    this.router.navigate(['logIn']);
  }

  routeToSubscribe() {
    this.router.navigate(['register']);
  }
}
