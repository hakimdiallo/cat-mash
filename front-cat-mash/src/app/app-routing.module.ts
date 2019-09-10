import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CatMashVoteComponent } from './cat-mash-vote/cat-mash-vote.component';
import { CatMashListComponent } from './cat-mash-list/cat-mash-list.component';

const routes: Routes = [
  {
    path: '',
    component: CatMashVoteComponent
  },
  {
    path: 'cats',
    component: CatMashListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
