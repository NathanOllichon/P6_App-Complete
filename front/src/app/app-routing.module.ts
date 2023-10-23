import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LogInComponent } from './pages/log-in/log-in.component';
import { RegisterComponent } from './pages/register/register.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ArticleDetailsComponent } from './pages/article-details/article-details.component';
import { CreateArticleComponent } from './pages/create-article/create-article.component';
import { AccountComponent } from './pages/account/account.component';
import { ThemesComponent } from './pages/themes/themes.component';

// consider a guard combined with canLoad / canActivate route option
// to manage unauthenticated user to access private routes
const routes: Routes = [
{ path: '', component: HomeComponent },
{ path: 'logIn', component: LogInComponent },
{ path: 'register', component: RegisterComponent },
{ path: 'articles', component: DashboardComponent },
{ path: 'themes', component: ThemesComponent },
{ path: 'articleDetails', component: ArticleDetailsComponent },
{ path: 'createArticle', component: CreateArticleComponent },
{ path: 'account', component: AccountComponent },
{ path: '**', redirectTo: 'articles' //TODO need canActivate if disconnected !
}

];

// { path: '404', component: NotFoundComponent },

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
