import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';
import { ExpenseService } from 'src/app/service/expense.service';

import * as moment from 'moment';

@Component({
  selector: 'app-expense-dashboard',
  templateUrl: './expense-dashboard.component.html',
  styleUrls: ['./expense-dashboard.component.scss']
})
export class ExpenseDashboardComponent implements OnInit {

  constructor(private expenseService:ExpenseService) { }

  expenseItem:number=0
  expenseGroup:number=0
  updateValue= true
  expenseTotal = 0;

  ngOnInit(): void {
    this.getExpenseDashboard()
    this.getExpenseItems()
    this.getExpenseItemThisWeek();
  }
  getExpenseDashboard(){
    this.expenseService.getExpenseDashboard().subscribe((res)=>{
      this.expenseItem = res.expenseItem;
      this.expenseGroup = res.expenseGroup;
    })
  }

  viewOptions = [
    {value: 'month', viewValue: 'this month'},
    {value: 'week', viewValue: 'this week'}
  ]

  getChangedOption(option){
    console.log(option);
    if(option === 'month'){
      this.getExpenseItems();
    }else if(option === 'week'){
      this.getExpenseItemThisWeek();
    }
  }


  getExpenseItemThisWeek(){
    let startDate = moment().startOf("week").toDate();
    let endDate = moment().endOf("week").toDate();
    let startString = this.getFormattedDate(startDate);
    let endString = this.getFormattedDate(endDate)

    console.log('start Date ',startDate,' ',endDate);
    this.expenseService.getExpensesItems(startString,endString,undefined)
    .subscribe( (res)=>{
      let dataItem = []
      res.forEach( (val)=>{
        let item = {
          name:val.expenseItemName,
          data:[val.expenseItemPrice]
        }
        dataItem.push(item);
      } )
      this.loadChartData(dataItem) 
    } )

  }

  getFormattedDate(date){
    let dd = String(date.getDate()).padStart(2, '0');
    let mm = String(date.getMonth() + 1).padStart(2, '0'); 
    let yyyy = date.getFullYear();
   return `${yyyy}-${mm}-${dd}`;
  }
  openDatePicker(dp){
    dp.open()
  }

  closeDatePicker(event:any,dp?:any){
    console.log(JSON.stringify(event));
    dp.close()
  }


  getExpenseItems(){
    let date = new Date();
    let dd = String(date.getDate()).padStart(2, '0');
    let mm = String(date.getMonth() + 1).padStart(2, '0'); 
    let yyyy = date.getFullYear();
    let startMonth = `${yyyy}-${mm}-${dd}`;
    this.expenseService.getExpensesItems(undefined,undefined,startMonth)
    .subscribe( (res)=>{
       let dataItem=[]
       res.forEach( (val)=>{
         let item = {
           name:val.expenseItemName,
           data:[val.expenseItemPrice]
         }
         dataItem.push(item);
       } ) 
       this.loadChartData(dataItem)
    } )
  }
  highcharts  = Highcharts
  chartOptions
  loadChartData(data){
    let chartOptions = {
      chart:{
        type:'spline'
      },
      title:{
       text:'Daily Expense'
      },
      xAxis:{
        categories:[1,2,3,4,5,6,7,8,9,10],
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
      series:data
    }

    this.chartOptions = chartOptions

  }
  

}
