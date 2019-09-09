import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CatMashVoteComponent } from './cat-mash-vote/cat-mash-vote.component';

const routes: Routes = [
  {
    path: '',
    component: CatMashVoteComponent
  },
  {
    path: 'cats',
    component: CatMashVoteComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
