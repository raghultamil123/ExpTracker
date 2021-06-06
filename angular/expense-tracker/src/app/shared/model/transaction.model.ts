export class Transaction{
    constructor(public amount:string,public moneyStatus:string,
        public moneyFromBank:string,
        public note?:string,public recipient?:string){
    }
}