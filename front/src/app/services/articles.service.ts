import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { ArticleToCreate } from '../interfaces/articleToCreate.interface';
// import { ArticlesList } from '../interfaces/articlesList.interface';
import { Article } from '../interfaces/article.interface';
import { CommentArticle } from '../interfaces/commentArticle.interface';
import { ArticleDetails } from '../interfaces/articleDetails.interface';
import { CommentaireCreate } from '../interfaces/commentaireCreate.interface';

@Injectable({
  providedIn: 'root'
})
export class ArticlesService {
  private pathService = 'http://localhost:3001/api';
  private headers = new HttpHeaders({
    'Access-Control-Allow-Origin' : '*',
    'Content-Type': 'application/json',
    Accept: 'application/json'
  });
  
  constructor(private http: HttpClient) { }

  public getArticles(): Observable<Article[]> {

    return this.http.get<Article[]>(this.pathService + '/article/list')
    .pipe(
      tap()
      );
  }

  public createArticle(articleInformations: ArticleToCreate): Observable<String> {
    JSON.stringify(articleInformations);

    return this.http.post<String>(`http://localhost:3001/api/article/create`, articleInformations, { headers: this.headers});
  }

  public getArticleDetailled(id: number): Observable<ArticleDetails> {

    return this.http.get<ArticleDetails>(this.pathService + `/article/${id}`)
    .pipe(
      tap()
      );
  }

  public createComment(commentaire: CommentArticle, articleId: number): Observable<String>  {
    var commentaireCreate: CommentaireCreate = new CommentaireCreate(commentaire, articleId);
    JSON.stringify(commentaireCreate);

    return this.http.post<String>(`http://localhost:3001/api/article/comment/create`, commentaireCreate, { headers: this.headers});
  }

}
