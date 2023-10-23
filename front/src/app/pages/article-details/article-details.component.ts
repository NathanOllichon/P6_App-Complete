import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/interfaces/article.interface';
import { ArticleDetails } from 'src/app/interfaces/articleDetails.interface';

@Component({
  selector: 'app-article-details',
  templateUrl: './article-details.component.html',
  styleUrls: ['./article-details.component.scss']
})
export class ArticleDetailsComponent implements OnInit {
  
  articleDatas: ArticleDetails =
    {
      "titre": "titre1",
      "date": new Date("10-12-2012"),
      "user": "Nat",
      "contenu": "contenu irem lopsus contenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsuscontenu irem lopsus",
      "id" : 1,
      "theme" : "SF"
    };

    //TODO type that !
    commentairesList: any[] = [
      {
        contenu:"test 1",
        auteur:"Charles"
      },
      {
        contenu:"Test 2",
        auteur:"Michel"
      }
    ]

    //TODO replace by request at init. get/me
    user : any = {
      name: "JEANYVES"
    }


  constructor() { }

  ngOnInit(): void {
    //TODO service.request article get article by id
  }

  sendComment():void{
    //TODO service.putComment on article id. 
    //refresh page ! like itcm ?
  }

  goBack(){
    window.history.back();
  }

}
