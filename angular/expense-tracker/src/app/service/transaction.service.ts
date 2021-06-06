import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Transaction } from '../shared/model/transaction.model';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private readonly BASE_URL = environment.BASE_URL+"transaction/"

  constructor(private httpClient:HttpClient) { }

  public getTransactions(bankArr:any,statusArr:any):Observable<Transaction[]>{
    return this.httpClient.get<Transaction[]>(this.BASE_URL+"available-transaction",{
      params:{
        bankNames:bankArr.join(),
        statusList:statusArr.join()
      }
    })

  }

  public getTransactionsFilter():Observable<any[]>{
    return this.httpClient.get<any[]>(this.BASE_URL+"8323dc67-8078-4b07-b485-30e9b957c133/transaction-filters")
  }
}
