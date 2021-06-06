import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ExpenseService } from 'src/app/service/expense.service';
import { ExpenseItem } from 'src/app/shared/model/expense-item.model';
import { Expense } from 'src/app/shared/model/expense.model';
import { ExpenseDetailsComponent } from '../expense-details/expense-details.component';
import { ExpenseAddComponent } from './expense-add/expense-add.component';

@Component({
  selector: 'app-expense-list',
  templateUrl: './expense-list.component.html',
  styleUrls: ['./expense-list.component.scss']
})
export class ExpenseListComponent implements OnInit {

  constructor(private expenseService:ExpenseService,private matDialog:MatDialog) { }
 
  expenses:Expense[] = [
  ]

  expenseItemsTotal:number = 0
  expenseItems:ExpenseItem[] = []
  ngOnInit(): void {
    this.getAllExpenses()
    this.getExpenseItems()
  }

  getExpenseItems(){
   this.expenseService.getAllExpenseItems()
   .subscribe( (res)=>{
     this.expenseItems = res.expenseItems;
     this.expenseItemsTotal = res.expenseItemsTotal
   }  )
  }

  getAllExpenses(){
    this.expenseService.getAllExpenses().subscribe ( (res)=>{
      this.expenses = res
    } ) 
  }
  viewExpense(expenseId:string){
    let dialog = this.matDialog.open(
      ExpenseDetailsComponent,{
        width:'700px',
        height: '400px',
        data:{
          'expenseId':expenseId
        }
      }
    )
  }

  openAddExpense(){
    let dialog = this.matDialog.open(
      ExpenseAddComponent,{
        width:'700px',
        height:'400px'
      }
    )
    dialog.afterClosed().subscribe( (res)=>{
      this.getAllExpenses();
      this.getExpenseItems();
    } )
  }

}
