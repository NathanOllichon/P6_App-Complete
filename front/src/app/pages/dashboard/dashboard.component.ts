import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable, of, tap } from 'rxjs';
import { Article } from 'src/app/interfaces/article.interface';
import { ArticlesService } from 'src/app/services/articles.service';
import * as moment from 'moment';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  articlesDatas: Article[] = [];
  public articlesDatas$ = of(this.articlesDatas);
  isSortDESC: Boolean = true;

  constructor(
    private router: Router,
    private articlesService: ArticlesService
    ) { }

  ngOnInit(): void {

    this.articlesService.getArticles().subscribe({
      next: (response: Article[]) => {
        this.articlesDatas = response;

        this.articlesDatas.sort((a,b) => {
          return  moment.utc(a.created_at).valueOf() - moment.utc(b.created_at).valueOf();
        });

      },
      error: (error: HttpErrorResponse)=> {
      //   nothing more for now, it's an MVP product.
      }
    });
  }

  goToArticlesDetails(idArticle : number) {
    this.router.navigate(['articleDetails',{id: idArticle}]);
  }

  goToCreateArticle() {
    this.router.navigate(['createArticle']);
  }

  updateIsSortDESC(){
    this.isSortDESC = !this.isSortDESC;

    if(this.isSortDESC){
      //article sort desc and refresh !
      this.articlesDatas.sort((a,b) => {
        return  moment.utc(a.created_at).valueOf() - moment.utc(b.created_at).valueOf();
      });
    }else{
      this.articlesDatas.sort((a,b) => {
        return  moment.utc(b.created_at).valueOf() - moment.utc(a.created_at).valueOf();
      });
    }

    this.articlesDatas = this.articlesDatas;
  }

}

