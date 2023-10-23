import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/app/interfaces/article.interface';
import { ArticlesList } from 'src/app/interfaces/articlesList.interface';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  //TODO replace by request
  private articlesThemeLists: ArticlesList[] =
    [
      {
        "theme": "testTheme1",
        "articles": [
          {
            "titre": "titre1",
            "date": new Date(10 / 12 / 2012),
            "user": "Nat",
            "contenu": "contenu irem lopsus",
            "id" : 1
          },
          {
            "titre": "2 titre2",
            "date": new Date(7 / 2 / 2020),
            "user": "Nat2",
            "contenu": "2 contenu2 irem lopsus",
            "id": 2
          },
        ]
      },
      {
        "theme": "testTheme2",
        "articles": [
          {
            "titre": "titre1Theme2",
            "date": new Date(28 / 10 / 2022),
            "user": "NatTheme2",
            "contenu": "contenu irem lopsus Theme2",
            "id": 3
          },
          {
            "titre": "2 titre2",
            "date": new Date(17 / 5 / 2023),
            "user": "Nat2",
            "contenu": "2 contenu2 irem lopsus Theme2",
            "id": 4
          },
        ]
      }];

  //articlesDatas = Service.mapToDashboardData(JSONarticlesDatas);
  articlesDatas: Article[] =
    [
      {
        "titre": "titre1",
        "date": new Date(10 / 12 / 2012),
        "user": "Nat",
        "contenu": "contenu irem lopsus contenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsus",
        "id" : 1
      },
      {
        "titre": "2 titre2",
        "date": new Date(7 / 2 / 2020),
        "user": "Nat2",
        "contenu": "2 contenu2 irem lopsus ",
        "id" : 2
      },
      {
        "titre": "titre1Theme2",
        "date": new Date(28 / 10 / 2022),
        "user": "NatTheme2",
        "contenu": "contenu irem lopsus Theme2",
        "id" : 3
      }
    ];


  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  goToArticlesDetails(idArticle : number) {
    //TODO add article id.
    console.log("id = " + idArticle)
    this.router.navigate(['articleDetails']);
  }

  goToCreateArticle() {
    this.router.navigate(['createArticle']);
  }

}
