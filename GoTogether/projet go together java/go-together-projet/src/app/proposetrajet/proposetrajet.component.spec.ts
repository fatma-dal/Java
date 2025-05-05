import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProposetrajetComponent } from './proposetrajet.component';

describe('ProposetrajetComponent', () => {
  let component: ProposetrajetComponent;
  let fixture: ComponentFixture<ProposetrajetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProposetrajetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProposetrajetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
