import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CatMashListComponent } from './cat-mash-list.component';

describe('CatMashListComponent', () => {
  let component: CatMashListComponent;
  let fixture: ComponentFixture<CatMashListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CatMashListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CatMashListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
