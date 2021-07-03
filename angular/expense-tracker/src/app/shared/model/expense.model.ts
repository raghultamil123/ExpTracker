import { ExpenseItem } from "./expense-item.model";

export class Expense{

    constructor(public expenseName:string,public expenseItems:ExpenseItem[],public expenseId?:string,public userId?:string){
        
    }

}