import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ThemeDTO } from 'src/app/interfaces/themeDTO.interface';
import { ThemesService } from 'src/app/services/themes.service';

@Component({
  selector: 'app-themes',
  templateUrl: './themes.component.html',
  styleUrls: ['./themes.component.scss']
})
export class ThemesComponent implements OnInit {
  themes: ThemeDTO[] = []

  constructor(
    private themesService: ThemesService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.themesService.getThemes().subscribe(
      (response: ThemeDTO[]) => {
        this.themes = response; 
      },
      error => console.log(error)
    )
  }

  subscribeTheme(themeId:number){
    this.themesService.subscribeToTheme(themeId).subscribe();
    this.router.navigate(['account']);
  }

  unSubscribeTheme(themeId:number){
    this.themesService.unsubscribeFromTheme(themeId).subscribe();
    this.router.navigate(['account']);
  }


}
