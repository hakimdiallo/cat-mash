import { Component, OnInit } from '@angular/core';
import { CatMashService } from '../cat-mash.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cat-mash-list',
  templateUrl: './cat-mash-list.component.html',
  styleUrls: ['./cat-mash-list.component.css']
})
export class CatMashListComponent implements OnInit {

  public cats: any;

  constructor(private catMashService: CatMashService, private router: Router) { }

  ngOnInit() {
    this.catMashService.getCatsOrderByScores().subscribe((data) => {
      this.cats = data;
    });
  }

}
