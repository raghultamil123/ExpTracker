import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';
import { ExpenseService } from 'src/app/service/expense.service';

import * as moment from 'moment';
import { HttpParams } from '@angular/common/http';
import { htmlAstToRender3Ast } from '@angular/compiler/src/render3/r3_template_transform';
import { ExpenseItem } from 'src/app/shared/model/expense-item.model';

@Component({
  selector: 'app-expense-dashboard',
  templateUrl: './expense-dashboard.component.html',
  styleUrls: ['./expense-dashboard.component.scss']
})
export class ExpenseDashboardComponent implements OnInit {
  chart;

  constructor(private expenseService:ExpenseService) {
    const self = this;
    this.chartCallback = chart => {
      // saving chart reference
      self.chart = chart;
    };
   }

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
    let userId = localStorage.getItem("userId");
    if(userId){
      this.expenseService.getExpenseDashboard(userId).subscribe((res)=>{
        this.expenseItem = res.expenseItem;
        this.expenseGroup = res.expenseGroup;
      })
    }
    
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
    let values = new HttpParams();
    values = values.set("startDate",startString);
    values = values.set("endDate",endString);
    let userId = localStorage.getItem("userId");
    if(userId){
      this.expenseService.getExpensesItems(userId,values)
      .subscribe( (response)=>{
          this.createDatafromMap(response)
       
      } )
    }
    

  }

  createDatafromMap(response){
    let categories=[];
    let data=[];
    let series=[]
    let value = response;
    console.log(value);


    Object.keys(value).forEach( (key)=>{
      let sum = 0;
      data=[];
      categories.push(key);
      value[key].forEach( (item)=>{
        sum += item.expenseItemPrice * item.expenseItemQuantity;
      } );
      
      data.push(sum);
      series.push({'name':key,'data':data});
    } ) 

    this.loadChartData(series,categories)
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
    let httpParams = new HttpParams();
    httpParams = httpParams.set("startMonth",startMonth);

    let userId = localStorage.getItem("userId");
    if(userId){
      this.expenseService.getExpensesItems(userId,httpParams)
      .subscribe( (res)=>{
        this.createDatafromMap(res)

      } )
    }
    
  }
  Highcharts = Highcharts;
  chartConstructor = "chart";
  chartCallback;

    chartOptions = {
    chart:{
      type:'bar'
    },
    title:{
     text:'Daily Expense'
    },
    xAxis:{
      categories:[],
      title:{
        text:'Days'
      }
    },
    yAxis:{
       Amount:[200,400,600,800,1000],
       title:{
         text:'Amount'
       }
    },
    series:[]
  }
  loadChartData(data,categories){
    const self = this,
    chart = this.chart;
    self.chartOptions.xAxis.categories = categories
    self.chartOptions.series=data;
    self.updateValue=true

  }
  

}
