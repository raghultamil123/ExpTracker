import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ExpenseDashboardComponent } from './expense/expense-dashboard/expense-dashboard.component';
import { ExpenseListComponent } from './expense/expense-list/expense-list.component';
import { ExpenseComponent } from './expense/expense.component';
import { SettingsComponent } from './settings/settings.component';
import { TransactionListComponent } from './transaction/transaction-list/transaction-list.component';
import { TransactionComponent } from './transaction/transaction.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path:'expense',component:ExpenseComponent,children:[
    {path:'dashboard',component:ExpenseDashboardComponent},
    {path:'expense-list',component:ExpenseListComponent}
  ]},
  {path:'transaction',component:TransactionComponent,children:[
    {path:'transaction-list',component:TransactionListComponent}
  ]},
  {path:'settings',component:SettingsComponent},
  {path:'user',component:UserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
