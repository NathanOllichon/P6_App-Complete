import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-themes',
  templateUrl: './themes.component.html',
  styleUrls: ['./themes.component.scss']
})
export class ThemesComponent implements OnInit {
  //TODO type data!
  themesDatas: any[] = [{
    "titre":"TitreTheme1",
    "description":"Description 1 irem"
  },
  {
    "titre":"TitreTheme 2",
    "description":"Description 2"
  },
  {
    "titre":"TitreTheme 3",
    "description":"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non hendrerit eros. Integer at odio rhoncus nisi pellentesque lacinia. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean quis massa sem. Nulla nec dolor non justo gravida volutpat. Vivamus ipsum justo, posuere dictum efficitur a, posuere et ipsum. Nunc pharetra eros a mi dapibus, sed consectetur dui lobortis. Proin dictum egestas mi, in porttitor nisi posuere eget. Phasellus vitae feugiat magna, sed lacinia lorem. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed finibus varius felis quis fringillntesque laoreet purus sapien, id accumsan ipsum maximus non. Curabitur laoreet et eros ut pharetra. Ut tincidunt turpis non porta sodales. Mauris sed ipsum eget nunc lacinia congue in sit amet neque. Phasellus interdum auctor lectus eget commodo. Fusce nec consectetur mi. Mauris sagittis turpis vitae porta sollicitudin. Quisque ut mi ut felis ultrices pretium. Nunc nisl ante, consequat vel porttitor quis, efficitur non massa. Sed vitae ultrices ipsum. Donec venenatis, tortor ac semper consequat, erat nisi aliquet nulla, eu sollicitudin magna mi vel justo. Etiam pharetra, erat scelerisque gravida accumsan, tellus lacus vestibulum nisi, ac finibus neque ipsum in odio. Ut non varius lectus. Duis laoreet odio sit amet venenatis convallis. In ac laoreet nisi. Sed id nibh quam. Suspendisse varius nunc lectus, hendrerit porta ex mattis ut. Mauris porttitor molestie tortor cursus cursus. Phasellus dapibus massa id efficitur dictum. Suspendisse bibendum aliquam ipsum in sodales. Ut et justo a nunc auctor interdum. Cras vehicula quis lacus id consectetur. Nulla sit amet egestas lorem, ac gravida arcu. Phasellus vel sollicitudin nunc, sed pretium mauris. Mauris laoreet est nulla, non consequat ipsum malesuada sit amet. Morbi eu nisl quis felis imperdiet condimentum. Ut sodales vel dui a rhoncus. Nam elementum risus lacus, at ornare tellus iaculis quis. Sed vel nisl et augue posuere fringilla. Ut laoreet sapien eu aliquam pretium. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce sodales dignissim sapien, non ornare lectus pharetra sit amet. Nam vitae purus ex. Aenean eget nisl tincidunt velit luctus finibus id pretium odio. Praesent gravida tincidunt scelerisque. Nunc laoreet fringilla lorem nec interdum. In gravida et sapien eget finibus. Donec suscipit risus sit amet aliquam dapibus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Orci varius natoque pen"
  },
  {
    "titre":"TitreTheme 4",
    "description":"Description 4"
  },
  {
    "titre":"TitreTheme 5",
    "description":"Description 5"
  },
  {
    "titre":"TitreTheme 6",
    "description":"Description 6"
  },
  {
    "titre":"TitreTheme 7",
    "description":"Description 7"
  }
]

  constructor() { }

  ngOnInit(): void {
  }

  subscribeTheme(themeId:number): void{
  }


}
