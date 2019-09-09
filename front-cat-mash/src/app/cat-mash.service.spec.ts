import { TestBed } from '@angular/core/testing';

import { CatMashService } from './cat-mash.service';

describe('CatMashService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CatMashService = TestBed.get(CatMashService);
    expect(service).toBeTruthy();
  });
});
