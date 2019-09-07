import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CatMashVoteComponent } from './cat-mash-vote.component';

describe('CatMashVoteComponent', () => {
  let component: CatMashVoteComponent;
  let fixture: ComponentFixture<CatMashVoteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CatMashVoteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CatMashVoteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
