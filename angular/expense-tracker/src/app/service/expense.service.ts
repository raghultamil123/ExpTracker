import { HttpClient, HttpParams } from '@angular/common/http';
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

  getAllExpenses(userId:string):Observable<Expense[]>{
    return this.httpClient.get<Expense[]>(this.EXPENSE_BASE_URL + `${userId}/available-expenses`)
  }

  saveExpense(userId:string,expense:Expense):Observable<any>{
    return this.httpClient.post(this.EXPENSE_BASE_URL + `${userId}/save-expense`,expense);
  }

  getExpenseById(userId:string,expenseId:string):Observable<Expense>{
    return this.httpClient.get<Expense>(this.EXPENSE_BASE_URL + `${userId}/expense-details`,{
      params:{
        'expenseId':expenseId
      }
    })
  }
  
  getAllExpenseItems(userId:string):Observable<ExpenseItemResponse>{
    return this.httpClient.get<ExpenseItemResponse>(this.EXPENSE_BASE_URL + `${userId}/expense-items` )
  }

  getExpenseDashboard(userId:string):Observable<any>{
 return this.httpClient.get<any>(this.EXPENSE_BASE_URL + `${userId}/dashboard`)
  }

  getExpensesItems(userId:string,values:HttpParams):Observable<Map<String,Array<ExpenseItem>>>{
    return this.httpClient.get<Map<String,Array<ExpenseItem>>>(this.EXPENSE_BASE_URL + `${userId}/dashboard/expense-items`,{
      params:values
    });
  }

}
