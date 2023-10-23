import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-connected',
  templateUrl: './menu-connected.component.html',
  styleUrls: ['./menu-connected.component.scss']
})
export class MenuConnectedComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navigateToAccount(){
    this.router.navigate(['account']);
  }

  
  navigateToArticles(){
    this.router.navigate(['articles']);
  }

  navigateToThemes(){
    this.router.navigate(['themes']);
  }
  

}
