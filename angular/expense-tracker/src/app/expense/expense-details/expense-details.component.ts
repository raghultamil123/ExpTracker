import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ExpenseService } from 'src/app/service/expense.service';
import { Expense } from 'src/app/shared/model/expense.model';

@Component({
  selector: 'app-expense-details',
  templateUrl: './expense-details.component.html',
  styleUrls: ['./expense-details.component.scss']
})
export class ExpenseDetailsComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: {expenseId: string},
  private expenseService:ExpenseService) { }

  ngOnInit(): void {
    console.log(this.data.expenseId);
    this.getExpenseById(this.data.expenseId)
  }

  getExpenseById(expenseId:string){
    this.expenseService.getExpenseById(expenseId).subscribe( (res)=>{
      this.expense = res
    } )
  }

  name = 'raghul'
  expense:Expense

  


}
