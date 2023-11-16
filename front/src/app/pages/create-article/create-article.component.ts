import { Component, OnInit } from '@angular/core';
import { ThemeListDTO } from 'src/app/interfaces/themeListDTO.interface';
import { ArticleToCreate } from 'src/app/interfaces/articleToCreate.interface';
import { ArticlesService } from 'src/app/services/articles.service';
import { ThemesService } from 'src/app/services/themes.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.scss']
})
export class CreateArticleComponent implements OnInit {

  formData: ArticleToCreate = {
    idTheme: 0,
    title: '',
    contenu: ''
  };

  themes: ThemeListDTO[] = [];

  constructor(
    private articlesService: ArticlesService,
    private themesService: ThemesService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.themesService.getThemesList().subscribe(
      (response: ThemeListDTO[]) => {
        this.themes = response; 
      },
      error => console.log(error)
    )
  }

  goBack() {
    window.history.back();
  }

  createArticle(formData: ArticleToCreate) {

    this.articlesService.createArticle(this.formData).subscribe(
      (response: String) => {},
      error => console.log(error)
    );

    this.router.navigate(['dashboard'])
  }

}

