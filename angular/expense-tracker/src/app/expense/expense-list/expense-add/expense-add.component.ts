import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { ExpenseService } from 'src/app/service/expense.service';
import { Expense } from 'src/app/shared/model/expense.model';

@Component({
  selector: 'app-expense-add',
  templateUrl: './expense-add.component.html',
  styleUrls: ['./expense-add.component.scss']
})
export class ExpenseAddComponent implements OnInit {

  constructor(public dialogRef:MatDialogRef<ExpenseAddComponent>,private expenseService:ExpenseService) { }

  ngOnInit(): void {
  }

  expense:Expense = {
    'expenseName':'',
    expenseItems:[],
    userId:localStorage.getItem("userId")

  }
  itemsTotal:number=0
  calculateItem(){
    let amount = 0;
    this.expense.expenseItems.forEach(
      (value)=>{
         amount  = amount +value.expenseItemPrice*value.expenseItemQuantity
      }
    )
    this.itemsTotal = amount;
  }
  


  addExpenseItems(){
    this.expense.expenseItems.push(
      {
        expenseItemName:'',
        expenseItemPrice:0,
        expenseItemQuantity:0,
        userId:localStorage.getItem("userId")
      }
    )
  }

  saveExpense(){
    let userId = localStorage.getItem("userId");
    if(userId){
      this.expenseService.saveExpense(userId,this.expense)
      .subscribe( (res)=>{
        this.dialogRef.close()
      },(err)=>{
        console.log(err);
      } )
    }
    
  }

}
