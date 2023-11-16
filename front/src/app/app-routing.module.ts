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
import { UnauthGuard } from 'src/helpers/unauth.guard';
import { AuthGuard } from 'src/helpers/auth.guard';

// consider a guard combined with canLoad / canActivate route option
// to manage unauthenticated user to access private routes
const routes: Routes = [
{ path: '', component: HomeComponent, canActivate: [UnauthGuard]},
{ path: 'logIn', component: LogInComponent, canActivate: [UnauthGuard]},
{ path: 'register', component: RegisterComponent, canActivate: [UnauthGuard]},
{ path: 'articles', component: DashboardComponent, canActivate: [AuthGuard]},
{ path: 'themes', component: ThemesComponent, canActivate: [AuthGuard]},
{ path: 'articleDetails', component: ArticleDetailsComponent, canActivate: [AuthGuard]},
{ path: 'createArticle', component: CreateArticleComponent, canActivate: [AuthGuard]},
{ path: 'account', component: AccountComponent, canActivate: [AuthGuard]},
{ path: '**', redirectTo: '' //TODO need canActivate if disconnected !
}

];

// { path: '404', component: NotFoundComponent },

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
