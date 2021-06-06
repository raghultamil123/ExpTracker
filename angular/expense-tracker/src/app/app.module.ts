import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HighchartsChartModule } from 'highcharts-angular';
import { AppCommonModule } from './shared/app-common/app-common.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ExpenseComponent } from './expense/expense.component';
import { ExpenseDashboardComponent } from './expense/expense-dashboard/expense-dashboard.component';
import { ExpenseListComponent } from './expense/expense-list/expense-list.component';
import { TransactionComponent } from './transaction/transaction.component';
import { TransactionListComponent } from './transaction/transaction-list/transaction-list.component';
import { SettingsComponent } from './settings/settings.component';
import { UserComponent } from './user/user.component';
import { ExpenseDetailsComponent } from './expense/expense-details/expense-details.component';
import { ExpenseInfoComponent } from './expense/expense-details/expense-info/expense-info.component';
import { ExpenseItemInfoComponent } from './expense/expense-details/expense-item-info/expense-item-info.component';
import { ExpenseAddComponent } from './expense/expense-list/expense-add/expense-add.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    ExpenseComponent,
    ExpenseDashboardComponent,
    ExpenseListComponent,
    TransactionComponent,
    TransactionListComponent,
    SettingsComponent,
    UserComponent,
    ExpenseDetailsComponent,
    ExpenseInfoComponent,
    ExpenseItemInfoComponent,
    ExpenseAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    HighchartsChartModule,
    AppCommonModule,
    FlexLayoutModule 

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
