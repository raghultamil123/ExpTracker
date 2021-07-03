import { animate, style, transition, trigger } from '@angular/animations';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { TransactionService } from 'src/app/service/transaction.service';
import { Transaction } from 'src/app/shared/model/transaction.model';


@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.scss'],
  animations:[
    trigger(
      'enterAnimation',[
        transition(':enter', [
          style({height:'0'}),
          animate('50ms',style({height:'*'}))
        ])  ,  
        transition(':leave', [
          animate('9ms', style({height:0}))
        ])
      
      ]
    )
  ]
})
export class TransactionListComponent implements OnInit , AfterViewInit{

  constructor(private transactionService:TransactionService) { }
  ngAfterViewInit(): void {
    console.log(this.sort)
    this.dataSource.sort = this.sort
  }

  showFilter = false;
  transactions:Transaction[] = [];
  checkboxData:any={};
  selectedItem:Map<String,Array<String>> = new Map()
  selectedItemCategory = ["status","bank"];

  toggleFilter(){
    this.showFilter = !this.showFilter;
  }


  @ViewChild(MatSort) sort: MatSort;

  isTransactionListLoading = true
  notes:string[] = [
    "Testing the largest message in the autocomplete feature it has the result",
    "Finding the content"
  ]

  selectedNote=''

  ngOnInit(): void {
    this.getTransactions()
    this.getTransactionFilters()
    this.selectedItem.set("bank",[])
    this.selectedItem.set("status",[])

  }


  getTransactions(): void {
    let userId = localStorage.getItem("userId");
    if(userId){
      this.transactionService.getTransactions(userId,[],[]).subscribe((res)=>{
        this.isTransactionListLoading = false
        this.transactions = res;
      },(err)=>{
        console.log(err);
      })
    }
    
  }

  columns:string[]=["amount","note","moneyFromBank","moneyStatus"]
  dataSource=new MatTableDataSource(this.transactions)


  getClassForStatus(status: string):string{
    if(status === 'credited'){
      return 'credited-text'
    }
    return 'debited-text';
  }

  getTransactionFilters(){
    let userId = localStorage.getItem("userId")
    this.transactionService.getTransactionsFilter(userId).subscribe( (res)=>{
this.checkboxData = res
let filters = localStorage.getItem("transaction-filter");
if(filters){
  console.log("filter");
  let filterObj = JSON.parse(filters)
  this.checkboxData = filterObj;
}

let filterChip = localStorage.getItem("transaction-chips");
if(filterChip){
  console.log("filter chip");
  let filterChipObj = JSON.parse(filterChip);
  this.selectedItem = new Map(filterChipObj);
}

    } )
  }

  removeFromSelect(){
    console.log("called");
  }

  selectedCheckboxChange($event:any,changedItem:any,type:string,index:number){
    if($event.checked === true){
      this.checkboxData[type][index].isChecked = true
      console.log(this.checkboxData);
      console.log(this.selectedItem.get(type));
      this.selectedItem.get(type).push(changedItem.name)
    }else if($event.checked === false){
      this.checkboxData[type][index].isChecked = false;
      this.selectedItem.set(type,this.selectedItem.get(type).filter( value=>value!== changedItem.name ));
    }
    console.log(this.selectedItem);
    localStorage.setItem("transaction-chips",JSON.stringify(Array.from(this.selectedItem.entries())));
    localStorage.setItem("transaction-filter",JSON.stringify(this.checkboxData));
  }

  searchTransactions(){
    
    this.isTransactionListLoading = true;
    console.log(this.selectedItem);
    let bankArr = this.selectedItem.get('bank')
    let statusArr = this.selectedItem.get('status')
    let userId = localStorage.getItem("userId");
    if(userId){
      this.transactionService.getTransactions(userId,bankArr,statusArr).subscribe( (res)=>{
        this.isTransactionListLoading = false;
        this.transactions = res;
        this.showFilter = false;
      } ) 
    }
    

  }


}
