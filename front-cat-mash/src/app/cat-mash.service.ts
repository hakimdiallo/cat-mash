import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CatMashService {

  private baseUrl = 'http://localhost:8090/api/cat-mash';

  constructor(private httpClient: HttpClient) { }

  public getCats() {
    return this.httpClient.get(this.baseUrl + '/cats');
  }

  public getCatsOrderByScores() {
    return this.httpClient.get(this.baseUrl + '/cats-order-score');
  }

  public getCatTotalScores() {
    return this.httpClient.get(this.baseUrl + '/cat/scores');
  }

  public getCatMah() {
    return this.httpClient.get(this.baseUrl + '/');
  }

  public voteForCat(id: string) {
    return this.httpClient.post(this.baseUrl + '/cat/vote', id);
  }

}
