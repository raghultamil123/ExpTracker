import { Component, Input, OnInit } from '@angular/core';
import { ExpenseItem } from 'src/app/shared/model/expense-item.model';

@Component({
  selector: 'app-expense-item-info',
  templateUrl: './expense-item-info.component.html',
  styleUrls: ['./expense-item-info.component.scss']
})
export class ExpenseItemInfoComponent implements OnInit {

  @Input() expenseItem:ExpenseItem[]

  constructor() { }

  ngOnInit(): void {
  }

}
