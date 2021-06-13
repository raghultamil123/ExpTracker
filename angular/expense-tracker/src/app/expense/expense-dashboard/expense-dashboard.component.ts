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
  updateValue= true

  ngOnInit(): void {
    this.getExpenseDashboard()
    this.getExpenseItems()
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
