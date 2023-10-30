import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-connected',
  templateUrl: './menu-connected.component.html',
  styleUrls: ['./menu-connected.component.scss']
})
export class MenuConnectedComponent{

  constructor(private router: Router) { }

  navigateToAccount() {
    this.router.navigate(['account']);
  }


  navigateToArticles() {
    this.router.navigate(['articles']);
  }

  navigateToThemes() {
    this.router.navigate(['themes']);
  }

  openNav() {
    const sidenav = document.getElementById("mySidenav");
    if(sidenav){
      sidenav.classList.add("active");
    }
  }

  /* Set the width of the side navigation to 0 */
  closeNav() {
    const sidenav = document.getElementById("mySidenav");

    if(sidenav){
      sidenav.classList.remove("active");
    }
  }

}
