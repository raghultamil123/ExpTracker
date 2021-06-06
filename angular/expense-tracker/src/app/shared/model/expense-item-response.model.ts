import { ExpenseItem } from "./expense-item.model";

export class ExpenseItemResponse{
    constructor(public expenseItems:ExpenseItem[],public expenseItemsTotal?:number) {
        
    }
}