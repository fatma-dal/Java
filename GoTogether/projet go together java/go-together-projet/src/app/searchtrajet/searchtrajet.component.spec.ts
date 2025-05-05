import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchtrajetComponent } from './searchtrajet.component';

describe('SearchtrajetComponent', () => {
  let component: SearchtrajetComponent;
  let fixture: ComponentFixture<SearchtrajetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SearchtrajetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchtrajetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
