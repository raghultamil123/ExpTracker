import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ExpenseItemResponse } from '../shared/model/expense-item-response.model';
import { ExpenseItem } from '../shared/model/expense-item.model';
import { Expense } from '../shared/model/expense.model';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  readonly EXPENSE_BASE_URL = environment.BASE_URL + "expense/"
  constructor(private httpClient:HttpClient) { }

  getAllExpenses():Observable<Expense[]>{
    return this.httpClient.get<Expense[]>(this.EXPENSE_BASE_URL + "available-expenses")
  }

  saveExpense(expense:Expense):Observable<any>{
    return this.httpClient.post(this.EXPENSE_BASE_URL + "save-expense",expense);
  }

  getExpenseById(expenseId:string):Observable<Expense>{
    return this.httpClient.get<Expense>(this.EXPENSE_BASE_URL + 'expense-details',{
      params:{
        'expenseId':expenseId
      }
    })
  }
  
  getAllExpenseItems():Observable<ExpenseItemResponse>{
    return this.httpClient.get<ExpenseItemResponse>(this.EXPENSE_BASE_URL + 'expense-items' )
  }

  getExpenseDashboard():Observable<any>{
 return this.httpClient.get<any>(this.EXPENSE_BASE_URL + 'dashboard')
  }

  getExpensesItems(startDate,endDate,startMonth):Observable<ExpenseItem[]>{
    return this.httpClient.get<ExpenseItem[]>(this.EXPENSE_BASE_URL + 'expenses-items',{
      params:{
        'startMonth':startMonth,
        'startDate':startDate,
        'endDate':endDate
      }
    });
  }

}
