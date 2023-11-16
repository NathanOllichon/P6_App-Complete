import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleDetails } from 'src/app/interfaces/articleDetails.interface';
import { CommentArticle } from 'src/app/interfaces/commentArticle.interface';
import { ArticlesService } from 'src/app/services/articles.service';

@Component({
  selector: 'app-article-details',
  templateUrl: './article-details.component.html',
  styleUrls: ['./article-details.component.scss']
})
export class ArticleDetailsComponent implements OnInit {

  articleDatas: ArticleDetails =
    {
      "titre": "",
      "created_at": new Date(),
      "auteur_name": "",
      "contenu": "",
      "id": 0,
      "theme_titre": "",
      commentaires: []
    };

  //TODO type that ! any
  //TODO get from articleDatas !
  // commentairesList: CommentArticle[] = []

  comment: CommentArticle =
    {
      contenu: "",
      user_name: ""
    };

  idArticle!: number;
  stringId: string | null;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private articlesService: ArticlesService
  ) {
    this.stringId = this.route.snapshot.paramMap.get('id');
    if (this.stringId) {
      this.idArticle = Number.parseInt(this.stringId);
    }
  }

  ngOnInit(): void {

    this.articlesService.getArticleDetailled(this.idArticle).subscribe({
      next: (response: ArticleDetails) => {
        this.articleDatas = response;

      },
      error: (error: HttpErrorResponse) => {
        console.log(error);
        //   nothing more for now, it's an MVP product.
      }
    });
  }

  sendComment(): void {
    //TODO service.putComment on article id. 
    this.articlesService.createComment(this.comment, this.articleDatas.id).subscribe({
      next: (response: String) => {
      },
      error: (error: HttpErrorResponse) => {
        console.log(error);
        //   nothing more for now, it's an MVP product.
      }
    });

    this.router.navigate(['articles']);

  }

  goBack() {
    window.history.back();
  }

}
