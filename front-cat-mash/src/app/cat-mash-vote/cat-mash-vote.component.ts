import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CatMashService } from '../cat-mash.service';

@Component({
  selector: 'app-cat-mash-vote',
  templateUrl: './cat-mash-vote.component.html',
  styleUrls: ['./cat-mash-vote.component.css']
})
export class CatMashVoteComponent implements OnInit {

  public scores: any;
  public catmash: any;

  constructor(private catMashService: CatMashService, private router: Router) {
    this.catmash = null;
  }

  ngOnInit() {
    this.catMashService.getCatTotalScores().subscribe((data) => {
      this.scores = data;
    });

    this.catMashService.getCatMah().subscribe((data) => {
      this.catmash = data;
    });
  }

  public vote(id: string) {
    console.log(id);
    this.catMashService.voteForCat(id).subscribe(response => {
      if (response) {
        this.catMashService.getCatTotalScores().subscribe((data) => {
          this.scores = data;
        });
      }
    });
  }

  public seeSweetTestCats() {
    this.router.navigateByUrl('/cats');
  }

}
