import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { ExpenseDashboardComponent } from './expense/expense-dashboard/expense-dashboard.component';
import { ExpenseListComponent } from './expense/expense-list/expense-list.component';
import { ExpenseComponent } from './expense/expense.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SettingsComponent } from './settings/settings.component';
import { TransactionListComponent } from './transaction/transaction-list/transaction-list.component';
import { TransactionComponent } from './transaction/transaction.component';
import { UserDetailsComponent } from './user/user-details/user-details.component';
import { UserRegistrationComponent } from './user/user-registration/user-registration.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [

  {path:'main',component:HomeComponent,canActivate:[AuthGuard],children:[
    {path:'expense',component:ExpenseComponent,children:[
      {path:'dashboard',component:ExpenseDashboardComponent},
      {path:'expense-list',component:ExpenseListComponent}
    ]},
    {path:'transaction',canActivate:[AuthGuard],component:TransactionComponent,children:[
      {path:'transaction-list',component:TransactionListComponent}
    ]},
    {path:'user',canActivate:[AuthGuard],component:UserComponent,children:[
      {path:'register',component:UserRegistrationComponent},
      {path: 'details',component:UserDetailsComponent},
      {path:'edit',component:UserRegistrationComponent}
    ]},
    {path:'settings',canActivate:[AuthGuard],component:SettingsComponent}
  ]},
  {path:'login',component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
