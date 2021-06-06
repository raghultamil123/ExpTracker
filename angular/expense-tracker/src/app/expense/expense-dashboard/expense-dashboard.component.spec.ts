import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpenseDashboardComponent } from './expense-dashboard.component';

describe('ExpenseDashboardComponent', () => {
  let component: ExpenseDashboardComponent;
  let fixture: ComponentFixture<ExpenseDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExpenseDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpenseDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
