import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';
import { ExpenseService } from 'src/app/service/expense.service';

@Component({
  selector: 'app-expense-dashboard',
  templateUrl: './expense-dashboard.component.html',
  styleUrls: ['./expense-dashboard.component.scss']
})
export class ExpenseDashboardComponent implements OnInit {

  constructor(private expenseService:ExpenseService) { }

  expenseItem:number=0
  expenseGroup:number=0

  ngOnInit(): void {
    this.getExpenseDashboard()
  }
  getExpenseDashboard(){
    this.expenseService.getExpenseDashboard().subscribe((res)=>{
      this.expenseItem = res.expenseItem;
      this.expenseGroup = res.expenseGroup;
    })
  }

  foods = [
    {value: 'steak-0', viewValue: 'this month'},
    {value: 'pizza-1', viewValue: 'this week'}
  ]

  openDatePicker(dp){
    dp.open()
  }

  closeDatePicker(event:any,dp?:any){
    console.log(JSON.stringify(event));
    dp.close()
  }
  highcharts  = Highcharts
  data = [{
    name:'Amount',
    data:[100,200,400,500,900]
  }]
  chartOptions = {
    chart:{
      type:'spline'
    },
    title:{
     text:'Daily Expense'
    },
    xAxis:{
      categories:["1 May 2021","2 May 2021","3 May 2021","4 May 2021","5 May 2021"],
      title:{
        text:'Days'
      }
    },
    yAxis:{
       Amount:[100,200,300,400,500,600,700,800],
       title:{
         text:'Amount'
       }
    },
    series:this.data
  }

}
