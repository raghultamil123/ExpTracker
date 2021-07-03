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

  public getTransactions(userId,bankArr:any,statusArr:any):Observable<Transaction[]>{
    return this.httpClient.get<Transaction[]>(this.BASE_URL+`${userId}/available-transaction`,{
      params:{
        bankNames:bankArr.join(),
        statusList:statusArr.join()
      }
    })

  }

  public getTransactionsFilter(userId):Observable<any[]>{
    return this.httpClient.get<any[]>(this.BASE_URL+`${userId}/transaction-filters`)
  }
}
