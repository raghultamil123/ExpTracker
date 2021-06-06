import { Component, Input, OnInit } from '@angular/core';
import { Expense } from 'src/app/shared/model/expense.model';

@Component({
  selector: 'app-expense-info',
  templateUrl: './expense-info.component.html',
  styleUrls: ['./expense-info.component.scss']
})
export class ExpenseInfoComponent implements OnInit {

  @Input() expense:Expense

  constructor() { }

  ngOnInit(): void {
  }

}
