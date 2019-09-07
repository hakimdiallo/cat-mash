import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CatMashVoteComponent } from './cat-mash-vote/cat-mash-vote.component';
import { CatMashListComponent } from './cat-mash-list/cat-mash-list.component';

@NgModule({
  declarations: [
    AppComponent,
    CatMashVoteComponent,
    CatMashListComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
