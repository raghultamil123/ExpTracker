import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpenseItemInfoComponent } from './expense-item-info.component';

describe('ExpenseItemInfoComponent', () => {
  let component: ExpenseItemInfoComponent;
  let fixture: ComponentFixture<ExpenseItemInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExpenseItemInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpenseItemInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
