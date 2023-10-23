import { Component, OnInit } from '@angular/core';
import { ArticleToCreate } from 'src/app/interfaces/articleToCreate.interface';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.scss']
})
export class CreateArticleComponent implements OnInit {

  //TODO no any, model datas, need to type all !
  formData: ArticleToCreate ={
    themeID: '',
    titre: '',
    contenu: ''
  };

  themes: any[] = 
  [
    {
      "titre": "theme 1",
      "id":1
    },
    {
      "titre": "theme 2",
      "id": 2
    },
    {
      "titre": "theme 3",
      "id": 3
    }
  ]

  constructor() { }

  ngOnInit(): void {
  }

  goBack(){
    window.history.back();
  }

  submit(){

  }

}
